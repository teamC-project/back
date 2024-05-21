package com.back.back.service.implimentation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.back.back.common.object.CustomOAuth2User;
import com.back.back.entity.UserEntity;
import com.back.back.repository.EmailAuthNumberRepository;
import com.back.back.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImplimentation extends DefaultOAuth2UserService {

  private final UserRepository userRepository;
  private final EmailAuthNumberRepository emailAuthNumberRepository;
  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

    OAuth2User oAuth2User = super.loadUser(userRequest);
    String oAuthClientName = userRequest.getClientRegistration().getClientName().toUpperCase();

    String id = getId(oAuth2User, oAuthClientName);

    UserEntity userEntity = userRepository.findBySnsId(id);
    if (userEntity == null) {
      return new CustomOAuth2User(id, oAuth2User.getAttributes(), false, oAuthClientName);
    } else {
      return new CustomOAuth2User(userEntity.getUserId(), oAuth2User.getAttributes(), true, null);
    }
  }

  private String getId(OAuth2User oAuth2User, String oAuthClientName) {
    String id = null;
    if (oAuthClientName.equals("KAKAO")) {
      Long longId = (Long) oAuth2User.getAttributes().get("id");
      id = longId.toString();
    }
    if (oAuthClientName.equals("NAVER")) {
      Map<String, String> response = (Map<String, String>) oAuth2User.getAttributes().get("response");
      id = response.get("id");
    }
    return id;
  }
}
