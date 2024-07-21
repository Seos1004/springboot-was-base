package kr.co.springboot_was_base.config.exception.custom;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BusinessException extends RuntimeException{
    private String ymlKey;
    private Exception exception;

    public BusinessException(String ymlKey , Exception exception){
        this.ymlKey = ymlKey;
        this.exception = exception;
    }

    public BusinessException(String ymlKey){
        this.ymlKey = ymlKey;
    }
}
