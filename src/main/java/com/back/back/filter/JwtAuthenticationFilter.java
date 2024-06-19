package com.back.back.filter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import com.back.back.entity.UserEntity;
import com.back.back.provider.JwtProvider;
import com.back.back.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtProvider jwtProvider;
  private final UserRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    try {

      String token = parseBearerToken(request);
      if (token == null) {
        filterChain.doFilter(request, response);
        return;
      }

      String userId = jwtProvider.validate(token);
      if (userId == null) {
        filterChain.doFilter(request, response);
        return;
      }

      UserEntity userEntity = userRepository.findByUserId(userId);
      if (userEntity == null) {
        filterChain.doFilter(request, response);
        return;
      }
      String role = userEntity != null ? userEntity.getUserRole() : null; // 수정: null 체크 추가

      List<GrantedAuthority> authorities = new ArrayList<>();
      if (role != null) {
        authorities.add(new SimpleGrantedAuthority(role)); // 수정: role이 null이 아닌 경우에만 권한 추가
    }

      AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, null,
          authorities);
      authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

      SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
      securityContext.setAuthentication(authenticationToken);

      SecurityContextHolder.setContext(securityContext);

    } catch (Exception exception) {
      exception.printStackTrace();
    }

    filterChain.doFilter(request, response);
  }

  private String parseBearerToken(HttpServletRequest request) {

    String authoization = request.getHeader("Authorization");
    boolean hasAuthorization = StringUtils.hasText(authoization);
    if (!hasAuthorization)
      return null;
    boolean isBearer = authoization.startsWith("Bearer ");
    if (!isBearer)
      return null;

    String token = authoization.substring(7);
    return token;

  }

}