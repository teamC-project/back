package com.back.back.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "email_auth_number")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailAuthNumberEntity {
    
    @Id
    private String email;

    private String authNumber;
    
}
