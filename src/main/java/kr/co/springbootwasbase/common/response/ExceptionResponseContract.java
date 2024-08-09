package kr.co.springbootwasbase.common.response;

public interface ExceptionResponseContract {
    String getCode();
    int getStatusCode();
    String getMessage();
}
