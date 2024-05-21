// package com.back.back.entity;

// import java.text.SimpleDateFormat;
// import java.time.Instant;
// import java.util.Date;

// import com.back.back.dto.request.qna.PostQnaBoardRequestDto;
// import com.back.back.dto.request.qna.PutQnaBoardRequestDto;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;






// @Entity(name = "qnaBoard")
// @Table(name = "qna_board")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// public class QnaBoardEntity {
//   @Id
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	private Integer qnaBoardNumber;
// 	private Boolean qnaBoardStatus;
// 	private String qnaBoardTitle;
// 	private String qnaBoardContents;
// 	private String qnaBoardWriterId;
// 	private String qnaBoardWriteDateTime;
// 	private Integer qnaBoardViewCount;
// 	private String qnaBoardComment;

// 	public QnaBoardEntity(PostQnaBoardRequestDto dto, String userId) {
// 		Date now =Date.from(Instant.now());
// 		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
// 			"yyyy-MM-dd HH:mm:ss"
// 		);
// 		String writeDatetime = simpleDateFormat.format(now);

// 		this.qnaBoardTitle = dto.getQnaBoardTitle();
// 		this.qnaBoardStatus = false;
// 		this.qnaBoardContents = dto.getQnaBoardContents();
// 		this.qnaBoardWriterId = userId;
// 		this.qnaBoardWriteDateTime = writeDatetime;
// 		this.qnaBoardViewCount = 0;
// 	}

// 	public void increaseQnaViewCount () {
// 		this.qnaBoardViewCount++;
// 	}

// 	public void updateQnaBoard(PutQnaBoardRequestDto dto) {
// 		this.qnaBoardTitle = dto.getQnaBoardTitle();
// 		this.qnaBoardContents =  dto.getQnaBoardContents();
// 	}
// }
