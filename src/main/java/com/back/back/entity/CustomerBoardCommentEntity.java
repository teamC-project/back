package com.back.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="customerBoardComment")
@Table(name="customerBoardComment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBoardCommentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer customerBoardCommentNumber;
  private Integer customerBoardNumber;
  private String customerBoardCommentWriterId;
  private String customerBoardCommentcontents;
  private String customerBoardCommentWriteDatetime;
}
