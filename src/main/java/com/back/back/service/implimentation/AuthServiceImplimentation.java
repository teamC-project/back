package com.back.back.service.implimentation;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.back.back.common.util.EmailAuthNumberUtil;
import com.back.back.dto.request.auth.EmailAuthCheckRequestDto;
import com.back.back.dto.request.auth.EmailAuthRequestDto;
import com.back.back.dto.request.auth.IdCheckRequestDto;
import com.back.back.dto.request.auth.PasswordFoundRequestDto;
import com.back.back.dto.request.auth.IdFoundRequestDto;
import com.back.back.dto.request.auth.SignInRequestDto;
import com.back.back.dto.request.auth.CustomerSignUpRequestDto;
import com.back.back.dto.request.auth.CustomerUpdateRequestDto;
import com.back.back.dto.request.auth.DesignerSignUpRequestDto;
import com.back.back.dto.request.auth.DesignerUpdateRequestDto;
import com.back.back.dto.response.ResponseDto;
import com.back.back.dto.response.auth.GetFindIdResponseDto;
import com.back.back.dto.response.auth.GetFindPasswordResponseDto;
import com.back.back.dto.response.auth.SignInResponseDto;
import com.back.back.entity.EmailAuthNumberEntity;
import com.back.back.entity.UserEntity;
import com.back.back.provider.JwtProvider;
import com.back.back.provider.MailProvider;
import com.back.back.repository.EmailAuthNumberRepository;
import com.back.back.repository.UserRepository;
import com.back.back.service.AuthService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplimentation implements AuthService {

  private final UserRepository userRepository;
  private final EmailAuthNumberRepository emailAuthNumberRepository;

  private final MailProvider mailProvider;
  private final JwtProvider jwtProvider;

  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {

    String accessToken = null;

    try {

      String userId = dto.getUserId();
      String userPassword = dto.getUserPassword();

      UserEntity userEntity = userRepository.findByUserId(userId);
      if (userEntity == null)
        return ResponseDto.signInFailed();

      String encodedPasword = userEntity.getUserPassword();
      boolean isMatched = passwordEncoder.matches(userPassword, encodedPasword);
      if (!isMatched)
        return ResponseDto.signInFailed();

      accessToken = jwtProvider.create(userId);
      if (accessToken == null)
        return ResponseDto.tokenCreationFailed();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return SignInResponseDto.success(accessToken);

  }

  @Override
  public ResponseEntity<ResponseDto> emailAuth(EmailAuthRequestDto dto) {

    try {

      String userEmail = dto.getUserEmail();
      boolean existedEmail = userRepository.existsByUserEmail(userEmail);
      if (existedEmail)
        return ResponseDto.duplicatedEmail();

      String authNumber = EmailAuthNumberUtil.createNumber();

      EmailAuthNumberEntity emailAuthNumberEntity = new EmailAuthNumberEntity(userEmail, authNumber);
      emailAuthNumberRepository.save(emailAuthNumberEntity);

      mailProvider.mailAuthSend(userEmail, authNumber);

    } catch (MessagingException exception) {
      exception.printStackTrace();
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success();

  }

  @Override
  public ResponseEntity<ResponseDto> emailAuthCheck(EmailAuthCheckRequestDto dto) {

    try {

      String userEmail = dto.getUserEmail();
      String authNumber = dto.getAuthNumber();

      boolean isMatched = emailAuthNumberRepository.existsByEmailAndAuthNumber(userEmail, authNumber);
      if (!isMatched)
        return ResponseDto.authenticationFailed();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success();

  }

  @Override
  public ResponseEntity<ResponseDto> signUp(CustomerSignUpRequestDto dto) {

    try {

      String userId = dto.getUserId();
      String userPassword = dto.getUserPassword();
      String userEmail = dto.getUserEmail();
      String authNumber = dto.getAuthNumber();

      boolean existedUser = userRepository.existsByUserId(userId);
      if (existedUser)
        return ResponseDto.duplicatedId();

      boolean existedEmail = userRepository.existsByUserEmail(userEmail);
      if (existedEmail)
        return ResponseDto.duplicatedEmail();

      boolean isMatched = emailAuthNumberRepository.existsByEmailAndAuthNumber(userEmail, authNumber);
      if (!isMatched)
        return ResponseDto.authenticationFailed();

      String encodeedPassword = passwordEncoder.encode(userPassword);
      dto.setUserPassword(encodeedPassword);

      UserEntity userEntity = new UserEntity(dto);

      userRepository.save(userEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<ResponseDto> signUp(DesignerSignUpRequestDto dto) {

    try {

      String userId = dto.getUserId();
      String userPassword = dto.getUserPassword();
      String userEmail = dto.getUserEmail();
      String authNumber = dto.getAuthNumber();

      boolean existedUser = userRepository.existsByUserId(userId);
      if (existedUser)
        return ResponseDto.duplicatedId();

      boolean existedEmail = userRepository.existsByUserEmail(userEmail);
      if (existedEmail)
        return ResponseDto.duplicatedEmail();

      boolean isMatched = emailAuthNumberRepository.existsByEmailAndAuthNumber(userEmail, authNumber);
      if (!isMatched)
        return ResponseDto.authenticationFailed();

      String encodeedPassword = passwordEncoder.encode(userPassword);
      dto.setUserPassword(encodeedPassword);

      UserEntity userEntity = new UserEntity(dto);

      userRepository.save(userEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success();

  }

  @Override
  public ResponseEntity<? super GetFindIdResponseDto> idFound(IdFoundRequestDto dto) {

    String userId = null;
    try {

      String userEmail = dto.getUserEmail();
      String authNumber = dto.getAuthNumber();

      UserEntity userEntity = userRepository.findByUserEmail(userEmail);
      if (userEntity == null)
        return ResponseDto.noExistEmail();

      boolean isMatched = emailAuthNumberRepository.existsByEmailAndAuthNumber(userEmail, authNumber);
      if (!isMatched)
        return ResponseDto.authenticationFailed();

      userId = userEntity.getUserId();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return GetFindIdResponseDto.success(userId);
  }

  @Override
  public ResponseEntity<? super GetFindPasswordResponseDto> passwordFound(PasswordFoundRequestDto dto) {

    try {

      String userId = dto.getUserId();
      String userEmail = dto.getUserEmail();
      String authNumber = dto.getAuthNumber();
      String userPassword = dto.getUserPassword();

      boolean existedUser = userRepository.existsByUserId(userId);
      if (!existedUser)
        return ResponseDto.noExistId();

      UserEntity userEntity = userRepository.findByUserEmail(userEmail);
      if (userEntity == null)
        return ResponseDto.noExistEmail();

      boolean isMatched = emailAuthNumberRepository.existsByEmailAndAuthNumber(userEmail, authNumber);
      if (!isMatched)
        return ResponseDto.authenticationFailed();

      String encodeedPassword = passwordEncoder.encode(userPassword);
      dto.setUserPassword(encodeedPassword);

      userPassword = userEntity.getUserPassword();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<ResponseDto> deleteUser(String userId) {

    try {
      UserEntity userEntity = userRepository.findByUserId(userId);
      if (userEntity == null)
        return ResponseDto.authorizationFailed();

      userRepository.delete(userEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<ResponseDto> customerUpdate(CustomerUpdateRequestDto dto) {

    try {
      String userId = dto.getUserId();

      UserEntity userEntity = userRepository.findByUserId(userId);
      if (userEntity == null)
        return ResponseDto.noExistId();

      userEntity.update(dto);
      userRepository.save(userEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<ResponseDto> designerUpdate(DesignerUpdateRequestDto dto) {
    try {

      String userId = dto.getUserId();

      UserEntity userEntity = userRepository.findByUserId(userId);
      if (userEntity == null)
        return ResponseDto.noExistId();

      userEntity.update(dto);
      userRepository.save(userEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  @Override
  public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {
    try {

      String userId = dto.getUserId();

      Boolean userEntity = userRepository.existsByUserId(userId);
      if (!userEntity)
        return ResponseDto.duplicatedId();

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

}