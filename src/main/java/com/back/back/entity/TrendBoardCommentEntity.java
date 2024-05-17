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

@Entity(name = "trendBoardComment")
@Table(name = "trendBoardComment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrendBoardCommentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer trendBoardCommentNumber;
  private Integer trandBoardNumber;
  private String trendBoardCommentWriterId;
  private String trendBoardCommentcontents;
  private String trendBoardCommentWriteDatetime;
}
