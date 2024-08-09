package kr.co.springbootwasbase.common.component.redis.enums;

import lombok.Getter;

@Getter
public enum CreateHashKeyResultEnum {

    SUCCESS("SUCCESS", "성공"),
    FAILURE_DUE_TO_KEY("FAILURE_DUE_TO_KEY", "key 를 확인해주세요"),
    ELEMENTAL_FAILURE("ELEMENTAL_FAILURE", "요소를 확인해주세요"),
    FAILURE_DUE_TO_EXPIRATION_TIME("FAILURE_DUE_TO_EXPIRATION_TIME", "만료시간을 확인해주세요");


    private final String code;
    private final String message;

    CreateHashKeyResultEnum(String code , String message) {
        this.code = code;
        this.message = message;
    }
}
