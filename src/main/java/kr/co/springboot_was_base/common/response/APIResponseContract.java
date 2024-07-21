package kr.co.springboot_was_base.common.response;

public interface APIResponseContract {
    String getCode();
    int getStatusCode();
    String getMessage();
}
