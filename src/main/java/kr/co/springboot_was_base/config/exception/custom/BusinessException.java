package kr.co.springboot_was_base.config.exception.custom;

import kr.co.springboot_was_base.common.response.ExceptionResponseContract;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BusinessException extends RuntimeException{
    private final ExceptionResponseContract exceptionResponseContract;
    private String[] args;
    private Exception exception;

    public BusinessException(ExceptionResponseContract exceptionResponseContract , String ... args){
        this.exceptionResponseContract = exceptionResponseContract;
        this.args = args;
    }

    public BusinessException(ExceptionResponseContract exceptionResponseContract){
        this.exceptionResponseContract = exceptionResponseContract;
    }

    public BusinessException(ExceptionResponseContract exceptionResponseContract , Exception exception){
        this.exceptionResponseContract = exceptionResponseContract;
        this.exception = exception;
    }

    public BusinessException(ExceptionResponseContract exceptionResponseContract , Exception exception ,  String ... args){
        this.exceptionResponseContract = exceptionResponseContract;
        this.exception = exception;
        this.args = args;
    }
}
