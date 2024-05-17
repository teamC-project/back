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

@Entity(name = "qnaBoard")
@Table(name = "qna_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QnaBoardEntity {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qnaBoardNumber;
	private boolean qnaBoardStatus;
	private String qnaBoardTitle;
	private String qnaBoardContents;
	private String qnaBoardWriterId;
	private String qnaBoardWriteDateTime;
	private Integer qnaBoardViewCount;
	private String qnaBoardComment;
}
