package com.back.back.dto.request.qna;

// import jakarta.validation.constraints.NotBlank;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class PostQnaBoardCommentRequestDto {
@NotBlank
public String qnaBoardComment;
}
=======
// package com.back.back.dto.request.qna;
=======
package com.back.back.dto.request.qna;
>>>>>>> 65f1d1f75adfa11dbdad945be3dc4578883613fd

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD
// @Getter
// @Setter
// @NoArgsConstructor
// public abstract class PostQnaBoardCommentRequestDto {
// @NotBlank
// public String qnaBoardComment;
// }
>>>>>>> 3e5392899efc054d691836d3d05a40deb2a1161f
=======
@Getter
@Setter
@NoArgsConstructor
public abstract class PostQnaBoardCommentRequestDto {
@NotBlank
public String qnaBoardComment;
}
>>>>>>> 65f1d1f75adfa11dbdad945be3dc4578883613fd
