package kr.co.springboot_was_base.config.exception.custom;

import kr.co.springboot_was_base.config.exception.enums.GlobalExceptionResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InterfaceException extends RuntimeException{
    private GlobalExceptionResponseEnum globalExceptionResponseEnum;
    private Exception exception;

    public InterfaceException(GlobalExceptionResponseEnum globalExceptionResponseEnum){
        this.globalExceptionResponseEnum = globalExceptionResponseEnum;
    }
}
