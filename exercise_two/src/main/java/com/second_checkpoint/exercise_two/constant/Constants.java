package com.second_checkpoint.exercise_two.constant;

public class Constants {

	private Constants() {
	}

	public final static String JWT_URL =  "http://localhost:8080/token";

	public final static String ITEM_URL =  "http://localhost:8080/api/v1/item/";

	public final static String SECRET =  "4194d1ab40d040cfd15b718450b7b527079c5d11d47e45d31043b74898d22e03dfa68c0e62f909e27e912d727b48c111adb41db31493b0c0278c8c74dd69586e";

	public final static String USER_ID = "userId";

	public final static String ROLE = "role";

	public final static String AUTHORIZATION_HEADER = "Authorization";

	public final static String BEARER_TOKEN = "Bearer ";

	public static final String USER = "CheckPoint2Exercise2";

	public static final String USER_EXERCISE_ONE = "CheckPoint2";

	public static final String PASSWORD = "Nisum2";

	public static final String REDIS_PASSWORD = "checkpoint2";

	public static final String USER_ROLE = "Admin";

	public static final int EXPIRATION = 50;
}
