package com.creawor.sales.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Jin_ on 2016/11/10.
 * 封装的响应json格式
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T> {

  private int code;

  private String message;

  private T data;

  private RestResult() {}

  public static <T> RestResult<T> newInstance() {
    return new RestResult<>();
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "RestResult{" +
        "result=" + code +
        ", message='" + message + '\'' +
        ", data=" + data +
        '}';
  }
}
