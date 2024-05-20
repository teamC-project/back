package com.back.back.entity;

import com.back.back.dto.request.auth.SignUpRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userGender;
    private Integer userAge;
    private String userImage;
    private String userCompanyName;
    private String userRole;
    private String joinPath;


  public UserEntity (SignUpRequestDto dto) {
    this.userId = dto.getUserId();
    this.userPassword = dto.getUserPassword();
    this.userEmail = dto.getUserEmail();
    this.userRole = "ROLE_USER";
    this.joinPath = "HOME";
  }
}