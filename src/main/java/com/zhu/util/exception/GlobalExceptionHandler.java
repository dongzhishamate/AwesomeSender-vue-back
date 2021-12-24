package com.zhu.util.exception;

import com.zhu.util.code.ErrorEnum;
import com.zhu.util.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * 处理自定义异常
   *
   */
  @org.springframework.web.bind.annotation.ExceptionHandler(value = DefinitionException.class)
  @ResponseBody
  public Result bizExceptionHandler(DefinitionException e) {
    return Result.defineError(e);
  }

  /**
   * 处理其他异常
   *
   */
  @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Result exceptionHandler( Exception e) {
    return Result.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
  }
}
