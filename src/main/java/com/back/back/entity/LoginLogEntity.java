package com.back.back.entity;

import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.dto.request.loginLog.getLoginLogRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "login_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sequence;
    private String loginId;
    private String loginDate;

    public LoginLogEntity(getLoginLogRequestDto dto, String loginId) {

        this.loginId = dto.getLoginId();
        this.loginDate = ChangeDateFormatUtil.getCurrentDatetiem();
    }
}
