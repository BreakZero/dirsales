package com.creawor.sales.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Jin_ on 2016/11/10.
 * 统一处理错误
 */
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> RestResult<T> runtimeExceptionHandler(Exception e) {
        LOGGER.error("---------> huge error!", e);
        return RestResultGenerator.genErrorResult(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> RestResult<T> illegalParamsExceptionHandler(MethodArgumentNotValidException e) {
        LOGGER.error("---------> invalid request!", e);
        return RestResultGenerator.genErrorResult(ErrorCode.ILLEGAL_PARAMS);
    }

    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public <T> RestResult<T> handleUploadError(MultipartException e) {
        return RestResultGenerator.genErrorResult(e.getCause().getMessage());
    }
}
