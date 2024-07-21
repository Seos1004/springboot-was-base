package kr.co.springboot_was_base.common.response.model;

import kr.co.springboot_was_base.common.response.APIResponseContract;
import kr.co.springboot_was_base.common.util.time.TimeFormatEnum;
import kr.co.springboot_was_base.common.util.time.TimeUtil;
import lombok.*;



@Getter
@Setter
@ToString
public class APIResponseModel<T> {
    private String timestamp;
    private String code;
    private int statusCode;
    private String message;
    private T data;

    public APIResponseModel(APIResponseContract response , T data) {
        this.timestamp = TimeUtil.getCurrentTimestamp(TimeFormatEnum.DATE_TIME_MILLIS);
        this.code = response.getCode();
        this.statusCode = response.getStatusCode();
        this.message = response.getMessage();
        this.data = data;
    }
    public APIResponseModel(APIResponseContract response , T data , String ... args) {
        this.timestamp = TimeUtil.getCurrentTimestamp(TimeFormatEnum.DATE_TIME_MILLIS);
        this.code = response.getCode();
        this.statusCode = response.getStatusCode();
        if (args != null && args.length > 0) {
            this.message = String.format(response.getMessage(), (Object[]) args);
        }
        else {
            this.message = response.getMessage();
        }
        this.data = data;
    }
}
