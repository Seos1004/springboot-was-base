package kr.co.springboot_was_base.common.response;

public interface ExceptionResponseContract {
    String getCode();
    int getStatusCode();
    String getMessage();
}
