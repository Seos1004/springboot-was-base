package kr.co.springboot_was_base.config.exception.enums;

import kr.co.springboot_was_base.common.response.ExceptionResponseContract;
import lombok.Getter;

@Getter
public enum GlobalExceptionResponseEnum implements ExceptionResponseContract {
    BAD_REQUEST("40000000", 400, "잘못된 요청입니다."),
    BAD_REQUEST_CUSTOM_MESSAGE("40000000", 400, "%s"),
    UNAUTHORIZED("40100000", 401, "인증에 실패하였습니다."),
    FORBIDDEN("40300000", 403, "접근이 거부되었습니다."),
    NOT_FOUND("40400000", 404, "요청하신 리소스를 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED("40500000", 405, "요청하신 HTTP 메서드는 허용되지 않습니다."),
    IM_A_TEAPOT("41800000", 418, "찻주전자로는 커피를 만들 수 없습니다."),
    INTERNAL_SERVER_ERROR("50000000", 500, "서버 내부 에러가 발생하였습니다."),
    SERVICE_UNAVAILABLE("50300000", 503, "서비스가 잠시 사용 불가능합니다.");

    private final String code;
    private final int statusCode;
    private final String message;

    GlobalExceptionResponseEnum(String code, int statusCode, String message) {
        this.code = code;
        this.statusCode = statusCode;
        this.message = message;
    }
}
