package com.dandelion.memberapp.exception;

public class WebserviceErrors {
	public static final int NETWORK_ERROR_CODE = 202;

	public static final String NETWORK_ERROR_MESSAGE = "network error";
	
	public static final int SERVER_INTERNAL_ERROR_CODE = 300;

	public static final String SERVER_INTERNAL_ERROR_MESSAGE = "server internal error";

	public static final int SIGNATURE_ERROR_CODE = 200;

	public static final String SIGNATURE_ERROR_MESSAGE = "signature error";

	public static final int SESSION_EXPIRED_CODE = 201;

	public static final String SESSION_EXPIRED_MESSAGE = "session expired";

	public static final int HTTP_404_CODE = 404;
	public static final String HTTP_404_MESSAGE = "HTTP 404 error";
	
	public static final int ILLEGAL_PARAMETER_ERROR_CODE = 501;
	public static final String ILLEGAL_PARAMETER_ERROR_MESSAGE = "illegal parameter or json string";
	
	public static final int RESULT_NULL_CODE = 611;
	public static final String RESULT_NULL_MESSAGE = "result is null";
	
	public static final int EMAIL_INVALID_CODE = 1001;
	public static final String EMAIL_INVALID_MESSAGE = "email invalid";

	public static final int PASSWORD_INVALID_CODE = 1002;
	public static final String PASSWORD_INVALID_MESSAGE = "password invalid";

	public static final int EMAIL_PASSWORD_WRONG_CODE = 1003;
	public static final String EMAIL_PASSWORD_WRONG_MESSAGE = "email or password is wrong";
	
	public static final int EMAIL_WRONG_CODE = 1004;
	public static final String EMAIL_WRONG_MESSAGE = "email is wrong or email is not exist";
	
	
	public static final int EMAIL_DUPLICATED_CODE = 1005;
	public static final String EMAIL_DUPLICATED_MESSAGE = "email duplicated";
	
	public static final int ALIAS_DUPLICATED_CODE = 1006;
	public static final String ALIAS_DUPLICATED_MESSAGE = "alias duplicated";
	
	public static final int UPLOAD_FILE_DENIED_CODE = 1007;
	public static final String UPLOAD_FILE_DENIED_MESSAGE = "upload file denied";
	
	public static final int USER_NOT_FOUND_CODE = 1011;
	public static final String USER_NOT_FOUND_MESSAGE = "user not found";
	
	public static final int EMAIL_SEND_ERROR_CODE = 1021;
	public static final String EMAIL_SEND_ERROR_MESSAGE = "email send error";
	
	public static final int FORGET_PASSWORD_TOKEN_NOT_FOUND = 1031;
	public static final String FORGET_PASSWORD_TOKEN_NOT_FOUND_MESSAGE = "invalid forget password token";
	
	public static final int FORGET_PASSWORD_TOKEN_EXPIRED = 1032;
	public static final String FORGET_PASSWORD_TOKEN_EXPIRED_MESSAGE = "token expired";
	
	public static final int TARGETUSERID_INVALID_CODE = 1040;
	public static final String TARGETUSERID_INVALID_MESSAGE = "you could not follow yourself";
}
