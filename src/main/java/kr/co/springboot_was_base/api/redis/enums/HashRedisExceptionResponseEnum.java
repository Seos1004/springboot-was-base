package kr.co.springboot_was_base.api.redis.enums;

import kr.co.springboot_was_base.common.response.ExceptionResponseContract;
import lombok.Getter;

@Getter
public enum HashRedisExceptionResponseEnum implements ExceptionResponseContract {
    FAIL("40001001", 400, "Success message %s"),
    FAIL_CUSTOM_MESSAGE("40001002", 400, "Success message %s %s %s");

    private final String code;
    private final int statusCode;
    private final String message;

    HashRedisExceptionResponseEnum(String code, int statusCode, String message) {
        this.code = code;
        this.statusCode = statusCode;
        this.message = message;
    }
}
