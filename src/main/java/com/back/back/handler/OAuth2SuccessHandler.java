package com.back.back.handler;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.back.back.provider.JwtProvider;
import com.back.back.common.object.CustomOAuth2User;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtProvider jwtProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        boolean isStatus = oAuth2User.isStatus();

        if (isStatus) {
            String userId = oAuth2User.getName();
            String token = jwtProvider.create(userId);
            response.sendRedirect("http://localhost:3200/sns/" + token + "/3200");
        } else {
            String snsId = oAuth2User.getName();
            String joinPath = oAuth2User.getJoinPath();
            response.sendRedirect("http://localhost:3200/auth/sign-up?snsId=" + snsId + "&joinPath=" + joinPath);
        }
    }

}
