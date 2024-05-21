package com.back.back.entity;

import com.back.back.dto.request.auth.CustomerSignUpRequestDto;
import com.back.back.dto.request.auth.DesignerSignUpRequestDto;

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
  private String userAge;
  private String userImage;
  private String userCompanyName;
  private String userRole;
  private String joinPath;
  private String snsId;

  public UserEntity(CustomerSignUpRequestDto customerDto) {
    this.userId = customerDto.getUserId();
    this.userPassword = customerDto.getUserPassword();
    this.userEmail = customerDto.getUserEmail();
    this.userGender = customerDto.getUserGender();
    this.userAge = customerDto.getUserAge();
    this.userRole = "ROLE_CUSTOMER";
    this.joinPath = customerDto.getJoinPath();
    this.snsId = customerDto.getSnsId();
  }

  public UserEntity(DesignerSignUpRequestDto desginerDto) {
    this.userId = desginerDto.getUserId();
    this.userPassword = desginerDto.getUserPassword();
    this.userEmail = desginerDto.getUserEmail();
    this.userGender = desginerDto.getUserGender();
    this.userAge = desginerDto.getUserAge();
    this.userCompanyName = desginerDto.getUserCompanyName();
    this.userImage = desginerDto.getUserImage();
    this.userRole = "ROLE_DESIGNER";
    this.joinPath = desginerDto.getJoinPath();
    this.snsId = desginerDto.getSnsId();
  }
}