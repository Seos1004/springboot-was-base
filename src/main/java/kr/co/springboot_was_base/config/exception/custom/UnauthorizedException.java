package kr.co.springboot_was_base.config.exception.custom;

import kr.co.springboot_was_base.config.exception.enums.GlobalExceptionResponseEnum;
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
