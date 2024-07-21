package kr.co.springboot_was_base.api.redis.enums;

import kr.co.springboot_was_base.common.response.APIResponseContract;
import lombok.Getter;

@Getter
public enum HashRedisAPIResponseEnum implements APIResponseContract {
    REDIS_SUCCESS("20001001", 200, "Success message %s"),
    REDIS_SUCCESS_ARGS_TEST("20001001", 200, "Success message %s %s %s");

    private final String code;
    private final int statusCode;
    private final String message;

    HashRedisAPIResponseEnum(String code, int statusCode, String message) {
        this.code = code;
        this.statusCode = statusCode;
        this.message = message;
    }
}
