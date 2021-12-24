package com.zhu.util.result;

import com.zhu.util.code.ErrorEnum;
import com.zhu.util.exception.DefinitionException;

public class Result<T> {

  private String code;
  private String msg;
  private T data;

  public Result(){}

  public Result(T data) {
    this.data = data;
  }

  public Result(Boolean success, String code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public static Result success() {
    Result result = new Result<>();
    result.setCode("0");
    result.setMsg("成功");
    return result;
  }

  public static <T> Result<T> success(T data) {
    Result<T> result = new Result<>(data);
    result.setCode("0");
    result.setMsg("成功");
    return result;
  }

  public static Result error(String code, String msg) {
    Result result = new Result();
    result.setCode(code);
    result.setMsg(msg);
    return result;
  }

  //自定义异常返回的结果
  public static Result defineError(DefinitionException de){
    Result result = new Result();
    result.setCode(de.getErrorCode());
    result.setMsg(de.getErrorMsg());
    result.setData(null);
    return result;
  }

  //其他异常处理方法返回的结果
  public static Result otherError(ErrorEnum errorEnum){
    Result result = new Result();
    result.setMsg(errorEnum.getErrorMsg());
    result.setCode(errorEnum.getErrorCode());
    result.setData(null);
    return result;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
