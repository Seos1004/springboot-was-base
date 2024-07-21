package kr.co.springboot_was_base.config.exception.custom;

import kr.co.springboot_was_base.config.exception.enums.GlobalExceptionResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ForbiddenException extends RuntimeException{
    private GlobalExceptionResponseEnum globalExceptionResponseEnum;
    private Exception exception;

    public ForbiddenException(GlobalExceptionResponseEnum globalExceptionResponseEnum){
        this.globalExceptionResponseEnum = globalExceptionResponseEnum;
    }
}
