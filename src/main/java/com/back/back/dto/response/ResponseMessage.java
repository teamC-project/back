package com.back.back.dto.response;

public interface ResponseMessage {

    String SUCCESS = "Success.";
    String VALIDATION_FAILED = "Validation Failed.";
    String DUPLICATED_ID = "Duplicated Id.";
    String DUPLICATED_PASSWORD = "Duplicated Password.";
    String DUPLICATED_EMAIL = "Duplicated Email.";
    String NO_EXIST_BOARD = "No Exist Board.";
    String NO_EXIST_EMAIL = "No Exist Email.";
    String NO_EXIST_ID = "No Exist Id.";
    String WRITTEN_COMMENT = "Written Comment.";
    String SIGN_IN_FAILED = "Sign in Failed.";
    String AUTHENTICATION_FAILED = "Authentication Failed.";
    String AUTHORIZATION_FAILED = "Authorization Failed.";
    String PAGE_NOT_FOUND = "Page Not Found.";
    String TOKEN_CREATION_FAILED = "Token creation Failed.";
    String DATABASE_ERROR = "Database Error.";
    String INVALID_ROOM_ID = "Invalid room ID";

}
