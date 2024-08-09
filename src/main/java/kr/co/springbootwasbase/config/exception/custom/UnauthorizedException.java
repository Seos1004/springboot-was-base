package kr.co.springbootwasbase.config.exception.custom;

import kr.co.springbootwasbase.config.exception.enums.GlobalExceptionResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UnauthorizedException extends RuntimeException{
    private GlobalExceptionResponseEnum globalExceptionResponseEnum;
    private Exception exception;

    public UnauthorizedException(GlobalExceptionResponseEnum globalExceptionResponseEnum){
        this.globalExceptionResponseEnum = globalExceptionResponseEnum;
    }
}
