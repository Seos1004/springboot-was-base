package kr.co.springboot_was_base.api.sample.enums;

import kr.co.springboot_was_base.common.response.ExceptionResponseContract;
import lombok.Getter;

@Getter
public enum SampleExceptionResponseEnum implements ExceptionResponseContract {

    //xxx99xxx
    // getSample process enum
    FAIL("40001001", 400, "Success message %s");
    // postSample process enum

    // putSample process enum

    // patchSample process enum

    // deleteSample process enum


    private final String code;
    private final int statusCode;
    private final String message;

    SampleExceptionResponseEnum(String code, int statusCode, String message) {
        this.code = code;
        this.statusCode = statusCode;
        this.message = message;
    }
}
