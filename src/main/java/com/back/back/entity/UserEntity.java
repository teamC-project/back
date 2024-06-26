package com.back.back.entity;

import com.back.back.dto.request.auth.CustomerSignUpRequestDto;
import com.back.back.dto.request.auth.DesignerSignUpRequestDto;
import com.back.back.dto.request.user.CustomerUpdateRequestDto;
import com.back.back.dto.request.user.DesignerUpdateRequestDto;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
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

    public UserEntity(DesignerSignUpRequestDto designerDto) {

        this.userId = designerDto.getUserId();
        this.userPassword = designerDto.getUserPassword();
        this.userEmail = designerDto.getUserEmail();
        this.userGender = designerDto.getUserGender();
        this.userAge = designerDto.getUserAge();
        this.userCompanyName = designerDto.getUserCompanyName();
        this.userImage = designerDto.getUserImage();
        this.userRole = "ROLE_DESIGNER";
        this.joinPath = designerDto.getJoinPath();
        this.snsId = designerDto.getSnsId();
    }


    public void update(CustomerUpdateRequestDto dto) {

        this.userAge = dto.getUserAge();
        this.userGender = dto.getUserGender();
    }

    public void update(DesignerUpdateRequestDto dto) {

        this.userAge = dto.getUserAge();
        this.userGender = dto.getUserGender();
        this.userImage = dto.getUserImage();
        this.userCompanyName =dto.getUserCompanyName();
    }
    
}