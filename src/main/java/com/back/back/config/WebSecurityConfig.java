package com.back.back.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.back.back.filter.JwtAuthenticationFilter;
import com.back.back.handler.OAuth2SuccessHandler;
import com.back.back.service.implimentation.OAuth2UserServiceImplimentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configurable
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

  private final JwtAuthenticationFilter jwtAuthenticationFilter;
  private final OAuth2UserServiceImplimentation oAuth2UserService;
  private final OAuth2SuccessHandler oAuth2SuccessHandler; 

  @Bean
  protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

    httpSecurity
        .httpBasic(HttpBasicConfigurer::disable)
        .csrf(CsrfConfigurer::disable)
        .sessionManagement(sessionManagement -> sessionManagement
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .cors(cors -> cors
            .configurationSource(corsConfigurationSource()))
        .authorizeHttpRequests(request -> request
            .requestMatchers("/", "/api/v1/auth/**", "/oauth2/callback/*", "/upload", "/file/*", "/api/v1/announcement_board/list").permitAll()
            .requestMatchers("/api/v1/service/customer_board/write").hasRole("CUSTOMER")
            .requestMatchers("/api/v1/service/my-page/info-customer").hasRole("CUSTOMER")
            .requestMatchers("/api/v1/service/designer_board/write").hasRole("DESIGNER")
            .requestMatchers("/api/v1/service/my-page/info-designer").hasRole("DESIGNER")
            .requestMatchers("/api/v1/service/qna_board/*/comment" ).hasRole("ADMIN")
						.requestMatchers( "/api/v1/service/trend_board/write").hasRole("ADMIN")
						.requestMatchers("/api/v1/service/announcement_board/write").hasRole("ADMIN")
            .anyRequest().authenticated())
        .oauth2Login(oauth2 -> oauth2
            .authorizationEndpoint(endpoint -> endpoint.baseUri("/api/v1/auth/oauth2"))
            .redirectionEndpoint(endpoint -> endpoint.baseUri("/oauth2/callback/*"))
            .userInfoEndpoint(endpoint -> endpoint.userService(oAuth2UserService))
            .successHandler(oAuth2SuccessHandler))
        .exceptionHandling(exception -> exception
            .authenticationEntryPoint(new AuthorizationFailEntryPoint()))
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return httpSecurity.build();

  }

  @Bean
  protected CorsConfigurationSource corsConfigurationSource() {

    CorsConfiguration configuration = new CorsConfiguration();
    configuration.addAllowedOrigin("*");
    configuration.addAllowedHeader("*");
    configuration.addAllowedMethod("*");

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);

    return source;
  }
}

class AuthorizationFailEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException, ServletException {

    authException.printStackTrace();
    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    response.getWriter().write("{ \"code\":\"AF\", \"message\": \"Authorization Failed\" }");
  }

}