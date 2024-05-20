package com.back.back.service.implimentation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.back.back.common.object.CustomOAuth2User;
import com.back.back.entity.EmailAuthNumberEntity;
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
    String userId = oAuthClientName + "_" + id.substring(0, 10);

    boolean isExistUser = userRepository.existsByUserId(userId);
    if (!isExistUser) {
      String userEmail = id + "@" + oAuthClientName.toLowerCase() + ".com";
      String userPassword = passwordEncoder.encode(id);

<<<<<<< HEAD
      
=======
>>>>>>> 6d5ac340992b56e82d0870e7c6c5320b5b0e9ebc
      EmailAuthNumberEntity emailAuthNumberEntity = new EmailAuthNumberEntity(userEmail, "0000");
      emailAuthNumberRepository.save(emailAuthNumberEntity);

      String userGender;
      UserEntity userEntity = new UserEntity(userId, userPassword, userEmail, userGender, "1", "1", "1", "1", "1");
      userRepository.save(userEntity);

    }
    return new CustomOAuth2User(userId, oAuth2User.getAttributes());
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
