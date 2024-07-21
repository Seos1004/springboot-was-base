package kr.co.springboot_was_base.config.exception.custom;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class InterfaceException extends RuntimeException{
    private String ymlKey;
    private Exception exception;

    public InterfaceException(String ymlKey , Exception exception){
        this.ymlKey = ymlKey;
        this.exception = exception;
    }

    public InterfaceException(String ymlKey){
        this.ymlKey = ymlKey;
    }
}
