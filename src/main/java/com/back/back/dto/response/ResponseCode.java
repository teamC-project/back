package com.back.back.dto.response;
public interface ResponseCode {
    
    String SUCCESS = "SU";
    String VALIDATION_FAILED = "VF";
    String DUPLICATED_ID = "DI";
    String DUPLICATED_EMAIL = "DE";
    String NO_EXIST_BOARD = "NB";
    String NO_EXIST_EMAIL = "NE";
    String NO_EXIST_ID = "NI";
    String WRITTEN_COMMENT = "WC";
    String SIGN_IN_FAILED = "SF";
	String NO_PERMISSION = "NP";
    String AUTHENTICATION_FAILED = "AF";
    String AUTHORIZATION_FAILED = "AF";
    String PAGE_NOT_FOUND = "PNF";
    String TOKEN_CREATION_FAILED = "TF";
    String DATABASE_ERROR = "DBE";
    String INVALID_ROOM_ID = "IRI";

}
