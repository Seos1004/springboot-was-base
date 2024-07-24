package kr.co.springboot_was_base.api.sample.enums;

import kr.co.springboot_was_base.common.response.APIResponseContract;
import lombok.Getter;

@Getter
public enum SampleAPIResponseEnum implements APIResponseContract {
    // getSample process enum
    GET_SAMPLE_SUCCESS("20099001", 200, "리소스를 정상적으로 조회하였씁니다."),

    // postSample process enum
    POST_SAMPLE_CREATED("20199002", 201, "정상적으로 리소스가 생성되었습니다."),

    // putSample process enum
    PUT_SAMPLE_CREATED("20099003", 200, "정상적으로 리소스가 수정되었습니다."),

    // patchSample process enum
    PATCH_SAMPLE_CREATED("20099004", 200, "정상적으로 값이 있는 요소만 수정되었습니다. [%s]"),

    // deleteSample process enum
    DELETE_SAMPLE_CREATED("20499005", 204, "정상적으로 리소스가 삭제되었습니다.");

    private final String code;
    private final int statusCode;
    private final String message;

    SampleAPIResponseEnum(String code, int statusCode, String message) {
        this.code = code;
        this.statusCode = statusCode;
        this.message = message;
    }
}
