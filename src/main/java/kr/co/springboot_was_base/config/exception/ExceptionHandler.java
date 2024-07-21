package kr.co.springboot_was_base.config.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import kr.co.springboot_was_base.common.response.model.ExceptionResponseModel;
import kr.co.springboot_was_base.common.util.time.TimeFormatEnum;
import kr.co.springboot_was_base.common.util.time.TimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ExceptionResponseModel handleException(HttpServletRequest request , Exception e) throws Exception{
        log.info("[RestControllerExceptionHandler.handleException]");
        ExceptionResponseModel result = new ExceptionResponseModel(
                //exception enum
                //request.getRequestURI()
        );
        errorLogging(e);
        return result;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponseModel handleMethodArgumentNotValidException(HttpServletRequest request , MethodArgumentNotValidException e) {
        log.info("[RestControllerExceptionHandler.handleMethodArgumentNotValidException]");
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder errorString = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        String errorMessage = null;
        for (FieldError error : errors) {
            String filedName = error.getField();
            errorMessage = error.getDefaultMessage();
            Object rejectedValue = error.getRejectedValue();
            errorString.append("[" + filedName + " : " + errorMessage + " -> " + rejectedValue + "]");
        }
        String returnErrorMessage = "요청 값을 확인해주세요. " + errorString;
        log.warn("[RestControllerExceptionHandler.handleMethodArgumentNotValidException] {}" , returnErrorMessage);
        ExceptionResponseModel result = new ExceptionResponseModel(
                dateUtils.getInstantNowToDate(),
                "40000000",
                "400",
                returnErrorMessage,
                request.getRequestURI()
        );
        return result;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BindException.class , ConstraintViolationException.class})
    public ExceptionResponseModel bindException(HttpServletRequest request , BindException e) {
        log.info("[RestControllerExceptionHandler.bindException]");
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder errorString = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        String errorMessage = null;
        for (FieldError error : errors) {
            String filedName = error.getField();
            errorMessage = error.getDefaultMessage();
            Object rejectedValue = error.getRejectedValue();
            errorString.append("[" + filedName + " : " + errorMessage + " -> " + rejectedValue + "]");
        }
        String returnErrorMessage = "요청 값을 확인해주세요. " + errorString;
        ExceptionResponseModel result = new ExceptionResponseModel(
                dateUtils.getInstantNowToDate(),
                "40000000",
                "400",
                returnErrorMessage,
                request.getRequestURI()
        );
        return result;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ServiceFail.class)
    public ExceptionResponseModel handleServiceFail(HttpServletRequest request , ServiceFail e) throws Exception{
        log.info("[RestControllerExceptionHandler.handleServiceFail]");
        return baseExceptionResponse(request , e);
    }
    private ExceptionResponseModel baseExceptionResponse(HttpServletRequest request , ServiceFail e){
        String ymlKey = e.getYmlKey();
        boolean isInvalid = false;
        if(null == ymlKey){
            isInvalid = true;
        }
        ResponseMessageModel exceptionInfo = null;
        if (isInvalid) {
            exceptionInfo = responseMessage.getExceptionInfo("not_specified_message");
        }else{
            exceptionInfo = responseMessage.getExceptionInfo(ymlKey);
        }
        if(null == exceptionInfo){
            exceptionInfo = responseMessage.getExceptionInfo("not_specified_message");
        }
        ExceptionResponseModel result = new ExceptionResponseModel(
                dateUtils.getInstantNowToDate(),
                exceptionInfo.getCode(),
                exceptionInfo.getStatus(),
                exceptionInfo.getDesc(),
                request.getRequestURI()
        );
        if(null != e.getException()){
            errorLogging(e.getException());
        }
        return result;
    }

    private void errorLogging(Exception e) {
        log.error("[RestControllerExceptionHandler.errorLogging] : {}", e);
    }
}
