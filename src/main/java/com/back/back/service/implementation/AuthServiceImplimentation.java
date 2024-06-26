package com.back.back.service.implementation;

import java.util.Date;
import java.time.Instant;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.back.back.entity.UserEntity;
import com.back.back.service.AuthService;
import com.back.back.provider.JwtProvider;
import com.back.back.provider.MailProvider;
import com.back.back.entity.LoginLogEntity;
import com.back.back.dto.response.ResponseDto;
import com.back.back.repository.UserRepository;
import com.back.back.entity.EmailAuthNumberEntity;
import com.back.back.repository.LoginLogRepository;
import com.back.back.common.util.EmailAuthNumberUtil;
import com.back.back.dto.request.auth.SignInRequestDto;
import com.back.back.dto.request.auth.IdCheckRequestDto;
import com.back.back.dto.request.auth.IdFoundRequestDto;
import com.back.back.dto.response.auth.SignInResponseDto;
import com.back.back.dto.request.auth.EmailAuthRequestDto;
import com.back.back.repository.EmailAuthNumberRepository;
import com.back.back.dto.response.auth.GetFindIdResponseDto;
import com.back.back.dto.request.auth.PasswordFoundRequestDto;
import com.back.back.dto.request.auth.PasswordReSetRequestDto;
import com.back.back.dto.request.auth.CustomerSignUpRequestDto;
import com.back.back.dto.request.auth.DesignerSignUpRequestDto;
import com.back.back.dto.request.auth.EmailAuthCheckRequestDto;

import jakarta.mail.MessagingException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplimentation implements AuthService {

    @Autowired
    private final UserRepository userRepository;
    private final EmailAuthNumberRepository emailAuthNumberRepository;
    private final LoginLogRepository loginLogRepository;
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

            LoginLogEntity loginLogEntity = new LoginLogEntity();
            loginLogEntity.setLoginId(dto.getUserId());

            Date now = Date.from(Instant.now());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String loginDate = simpleDateFormat.format(now);
            loginLogEntity.setLoginDate(loginDate);

            loginLogRepository.save(loginLogEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignInResponseDto.success(accessToken);
    }

    @Override
    public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {

        try {
            String userId = dto.getUserId();
            Boolean userEntity = userRepository.existsByUserId(userId);

            if (userEntity)
            return ResponseDto.duplicatedId();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> passwordFoundIdCheck(IdCheckRequestDto dto) {

        try {
            String userId = dto.getUserId();
            Boolean userEntity = userRepository.existsByUserId(userId);

            if (!userEntity)
            return ResponseDto.noExistId();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
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
    public ResponseEntity<ResponseDto> idFoundEmailAuth(EmailAuthRequestDto dto) {

        try {

            String userEmail = dto.getUserEmail();
            boolean existedEmail = userRepository.existsByUserEmail(userEmail);
            if (!existedEmail)
            return ResponseDto.noExistEmail();

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
    public ResponseEntity<ResponseDto> passwordFoundEmailAuth(EmailAuthRequestDto dto) {

        try {
            String userEmail = dto.getUserEmail();
            boolean existedEmail = userRepository.existsByUserEmail(userEmail);
            if (!existedEmail)
            return ResponseDto.noExistEmail();

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
    public ResponseEntity<ResponseDto> passwordFound(PasswordFoundRequestDto dto) {

        try {
            String userId = dto.getUserId();
            String userEmail = dto.getUserEmail();
            String authNumber = dto.getAuthNumber();

            boolean existedUserId = userRepository.existsByUserId(userId);
            if (!existedUserId)
            return ResponseDto.noExistId();

            boolean existedUserEmail = userRepository.existsByUserEmail(userEmail);
            if (!existedUserEmail)
            return ResponseDto.noExistEmail();

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
    public ResponseEntity<ResponseDto> resetPassword(PasswordReSetRequestDto dto) {
        try {
            String userId = dto.getUserId();
            UserEntity userEntity = userRepository.findByUserId(userId);

            if (userEntity == null) {
            return ResponseDto.noExistId();
            }

            String userPassword = dto.getUserPassword();
            String encodedPassword = passwordEncoder.encode(userPassword);
            userEntity.setUserPassword(encodedPassword);

            userRepository.save(userEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

}
