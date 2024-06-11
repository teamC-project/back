package com.back.back.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "loginLog")
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
  private LocalDate loginDate;

}
