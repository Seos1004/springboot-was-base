package kr.co.springboot_was_base.common.response.model;

import kr.co.springboot_was_base.common.response.APIResponseContract;
import kr.co.springboot_was_base.common.response.ExceptionResponseContract;
import kr.co.springboot_was_base.common.util.time.TimeFormatEnum;
import kr.co.springboot_was_base.common.util.time.TimeUtil;
import lombok.*;


@Getter
@Setter
@ToString
public class ExceptionResponseModel{
    private String timestamp;
    private String code;
    private int statusCode;
    private String message;

    public ExceptionResponseModel(ExceptionResponseContract response) {
        this.timestamp = TimeUtil.getCurrentTimestamp(TimeFormatEnum.DATE_TIME_MILLIS);
        this.code = response.getCode();
        this.statusCode = response.getStatusCode();
        this.message = response.getMessage();
    }
    public ExceptionResponseModel(ExceptionResponseContract response , String ... args) {
        this.timestamp = TimeUtil.getCurrentTimestamp(TimeFormatEnum.DATE_TIME_MILLIS);
        this.code = response.getCode();
        this.statusCode = response.getStatusCode();
        if (args != null && args.length > 0) {
            this.message = String.format(response.getMessage(), (Object[]) args);
        }
        else {
            this.message = response.getMessage();
        }
    }
}
