package kr.co.springbootwasbase.config.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import kr.co.springbootwasbase.common.response.model.ExceptionResponseModel;
import kr.co.springbootwasbase.config.exception.custom.BusinessException;
import kr.co.springbootwasbase.config.exception.custom.InterfaceException;
import kr.co.springbootwasbase.config.exception.enums.GlobalExceptionResponseEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ExceptionResponseModel exceptionHandle(HttpServletRequest request , Exception e){
        log.error("[GlobalExceptionHandler.handleException] {}" , request.getRequestURI());
        errorLogging(e , request);
        return new ExceptionResponseModel(GlobalExceptionResponseEnum.INTERNAL_SERVER_ERROR , request);
    }

    @ExceptionHandler(value = HttpServerErrorException.class)
    public ExceptionResponseModel httpServerErrorException(HttpServletRequest request , Exception e){
        log.error("[GlobalExceptionHandler.httpServerErrorException] {}" , request.getRequestURI());
        errorLogging(e , request);
        return new ExceptionResponseModel(GlobalExceptionResponseEnum.SERVICE_UNAVAILABLE , request);
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public ExceptionResponseModel noResourceFoundException(HttpServletRequest request , Exception e){
        log.error("[GlobalExceptionHandler.noResourceFoundException] {}" , request.getRequestURI());
        errorLogging(e , request);
        return new ExceptionResponseModel(GlobalExceptionResponseEnum.BAD_REQUEST , request);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ExceptionResponseModel missingServletRequestParameterException(HttpServletRequest request , MissingServletRequestParameterException e){
        log.error("[GlobalExceptionHandler.missingServletRequestParameterException] {}" , request.getRequestURI());
        String message = String.format("'%s' 파라미터가 누락되었습니다.", e.getParameterName());
        log.error("[GlobalExceptionHandler.missingServletRequestParameterException] {} : {}" , request.getRequestURI() , message);
        return new ExceptionResponseModel(GlobalExceptionResponseEnum.BAD_REQUEST_CUSTOM_MESSAGE , request , message);
    }


    @ExceptionHandler(value = {HandlerMethodValidationException.class})
    public ExceptionResponseModel handlerMethodValidationException(HttpServletRequest request , HandlerMethodValidationException e) {
        log.error("[GlobalExceptionHandler.handlerMethodValidationException] {}" , request.getRequestURI());
        String errorMessage = e.getAllValidationResults().stream()
                .flatMap(allValidationResult -> allValidationResult.getResolvableErrors().stream())
                .map(error -> String.format("%s : %s", getFirstElement(error.getCodes()), error.getDefaultMessage()))
                .collect(Collectors.joining("\n"));
        log.error("[GlobalExceptionHandler.handlerMethodValidationException] {} : {}" , request.getRequestURI() , errorMessage);
        return new ExceptionResponseModel(GlobalExceptionResponseEnum.BAD_REQUEST_CUSTOM_MESSAGE, request, errorMessage);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ExceptionResponseModel methodArgumentNotValidException(HttpServletRequest request , MethodArgumentNotValidException e) {
        log.error("[GlobalExceptionHandler.methodArgumentNotValidException] {}" , request.getRequestURI());
        String aggregatedErrors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> String.format("[%s : %s -> %s]", error.getField(), error.getDefaultMessage(), error.getRejectedValue()))
                .collect(Collectors.joining("\n"));
        String detailedErrorMessage = String.format("요청 값을 확인해주세요. %s", aggregatedErrors);
        log.error("[GlobalExceptionHandler.methodArgumentNotValidException] {} : {}" , request.getRequestURI() , detailedErrorMessage);
        return new ExceptionResponseModel(GlobalExceptionResponseEnum.BAD_REQUEST_CUSTOM_MESSAGE , request , detailedErrorMessage);
    }

    @ExceptionHandler(value = {BindException.class , ConstraintViolationException.class})
    public ExceptionResponseModel bindException(HttpServletRequest request , BindException e) {
        log.error("[GlobalExceptionHandler.bindException] {}" , request.getRequestURI());
        String aggregatedErrors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> String.format("[%s : %s -> %s]", error.getField(), error.getDefaultMessage(), error.getRejectedValue()))
                .collect(Collectors.joining("\n"));
        String detailedErrorMessage = String.format("요청 값을 확인해주세요. %s", aggregatedErrors);
        log.error("[GlobalExceptionHandler.bindException] {} : {}" , request.getRequestURI() , detailedErrorMessage);
        return new ExceptionResponseModel(GlobalExceptionResponseEnum.BAD_REQUEST_CUSTOM_MESSAGE , request , detailedErrorMessage);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ExceptionResponseModel businessException(HttpServletRequest request , BusinessException e) {
        log.error("[GlobalExceptionHandler.businessException] {}" , request.getRequestURI());
        errorLogging(e.getException() , request);
        return new ExceptionResponseModel(e.getExceptionResponseContract() , request , e.getArgs());
    }

    @ExceptionHandler(value = InterfaceException.class)
    public ExceptionResponseModel interfaceException(InterfaceException e) throws Exception {
        //todo 요청한  full url , req , res 정보 노출
        log.error("[GlobalExceptionHandler.interfaceException] ");
        throw new Exception();
    }

    private String getFirstElement(String[] elements) {
        return (elements != null && elements.length > 0) ? elements[0] : "";
    }

    private void errorLogging(Exception e , HttpServletRequest request) {
        log.error("[GlobalExceptionHandler.errorLogging] : {} ", request.getRequestURI() , e);
    }
}
