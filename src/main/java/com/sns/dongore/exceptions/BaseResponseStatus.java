package com.sns.dongore.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor @Getter
public enum BaseResponseStatus {

    // 공통에러
    SUCCESS(true, HttpStatus.OK, "성공"),
    ACCEPTED(true, HttpStatus.CREATED, "생성완료"),
    BAD_REQUEST_PARAM(false, HttpStatus.BAD_REQUEST, "파라미터 타입이 잘못되었습니다."),


    // Feed 관련
    NOT_FOUND_POST(false, HttpStatus.NOT_FOUND, "Post가 존재하지 않습니다."),


    // HashTag 관련
    NOT_FOUND_HASHTAG(false, HttpStatus.NOT_FOUND, "HashTag가 존재하지 않습니다."),


    // Photo 관련
    BAD_REQUEST_PHOTO(false, HttpStatus.BAD_REQUEST, "Photo Field가 null입니다."),
    BAD_REQUEST_PHOTO_SIZE_EXCEED(false, HttpStatus.BAD_REQUEST, "사진 크기가 너무 큽니다. 1048576 bytes를 넘기지 말아주세요."),

    PHOTO_ID_NOT_EXIST(false, HttpStatus.NOT_FOUND,"해당 Photo Id는 존재하지 않습니다." ),


    // User 관련
    EMAIL_TYPE_WRONG(false, HttpStatus.BAD_REQUEST, "이메일 형식이 잘못되었습니다."),
    PASSWORD_TYPE_WRONG(false, HttpStatus.BAD_REQUEST, "패스워드 형식이 잘못되었습니다."),

    EMAIL_DUPLICATED(false, HttpStatus.BAD_REQUEST, "이메일이 중복되었습니다."),
    NICKNAME_DUPLICATED(false, HttpStatus.BAD_REQUEST, "닉네임이 중복되었습니다."),

    USER_NOT_FOUND(false, HttpStatus.NOT_FOUND, "유저가 존재하지 않습니다."),

    // Feed 관련
    FEED_NOT_FOUND(false, HttpStatus.NOT_FOUND, "존재하지 않은 FeedId 입니다."),
    PHOTO_UPLOAD_FAIL(false, HttpStatus.INTERNAL_SERVER_ERROR, "사진 업로드 도중 문제가 발생했습니다. 서버 관리자에게 문의하세요." );


    private final Boolean isSuccess;
    private final HttpStatus statusCode;
    private final String detail;
}
