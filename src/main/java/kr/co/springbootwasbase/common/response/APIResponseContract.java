package kr.co.springbootwasbase.common.response;

public interface APIResponseContract {
    String getCode();
    int getStatusCode();
    String getMessage();
}
