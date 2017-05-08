package com.creawor.sales.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jin_ on 2016/11/10.
 * Gen RestResult
 */
public class RestResultGenerator {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RestResultGenerator.class.getSimpleName());

    /**
     * normal
     *
     * @param code
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genResult(int code, T data, String message) {
        RestResult<T> result = RestResult.newInstance();
        result.setCode(code);
        result.setData(data);
        result.setMessage(message);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Generate rest result:{}", result);
        }
        return result;
    }

    /**
     * success
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genSuccessResult(T data) {
        return genResult(Const.SUCCESS_CODE, data, null);
    }

    /**
     * error message
     *
     * @param message error message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genErrorResult(String message) {
        return genResult(Const.FAIL_CODE, null, message);
    }

    /**
     * error
     *
     * @param error error enum
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genErrorResult(ErrorCode error) {
        return genErrorResult(error.getMessage());
    }

    /**
     * success no message
     *
     * @return
     */
    public static RestResult genSuccessResult() {
        return genSuccessResult(null);
    }
}

