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
public interface ResponseCode {
  String SUCCESS = "SU";
  String VALIDATION_FAILED = "VF";
  String DUPLICATED_ID = "DI";
  String DUPLICATED_EMAIL = "DE";
  String NO_EXIST_BOARD = "NB";
  String NO_EXIST_EMAIL = "NE";
  String NO_EXIST_ID = "NI";
  String NO_EXIST_PASSWORD = "NP";
  String WRITTEN_COMMENT = "WC";
  String SIGN_IN_FAILED = "SF";
  String AUTHENTICATION_FAILED = "AF";
  String AUTHORIZATION_FAILED = "AF";
  String PAGE_NOT_FOUND = "PNF";
  String TOKEN_CREATION_FAILED = "TF";
  String MAIL_SEND_FAILED = "MF";
  String DATABASE_ERROR = "DBE";
  String INVALID_ROOM_ID = "IRI";
  String INTERNAL_SERVER_ERROR = "ISE";
}
