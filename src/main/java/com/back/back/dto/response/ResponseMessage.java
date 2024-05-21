package com.back.back.dto.response;

// 200 성공 : SU / Success.
// 400 필수 데이터 미입력 : VF / Varidation Failed.
// 400 중복된 아이디 : DI / Duplicated Id.
// 400 중복된 이메일 : DE / Duplicated Email.
// 400 존재하지 않는 게시물 : NB / No Exist Board.
// 400 답변 완료된 게시물 : WC / Written Comment.
// 401 로그인 정보 불일치 : SF / Sign in Failed.
// 401 인증 실패 : AF / Authentication Failed.
// 403 인가 실패 : AF / Authorization Failed
// 404 없는 페이지 : PNF / Page Not Found.
// 500 토큰 생성 실패 : TF / Token creation Failed.
// 500 이메일 전송 실패 : MF / Mail send Failed.
// 500 데이터베이스 오류 : DBE / Database Error.
public interface ResponseMessage {
  String SUCCESS = "Success.";
  String VALIDATION_FAILED = "Validation Failed.";
  String DUPLICATED_ID = "Duplicated Id.";
  String DUPLICATED_EMAIL = "Duplicated Email.";
  String NO_EXIST_BOARD = "No Exist Board.";
  String WRITTEN_COMMENT = "Written Comment.";
  String SIGN_IN_FAILED = "Sign in Failed.";
  String AUTHENTICATION_FAILED = "Authentication Failed.";
  String AUTHORIZATION_FAILED = "Authorization Failed.";
  String PAGE_NOT_FOUND = "Page Not Found.";
  String TOKEN_CREATION_FAILED = "Token creation Failed.";
  String MAIL_SEND_FAILED = "Mail send Failed.";
  String DATABASE_ERROR = "Database Error.";
}
