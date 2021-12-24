package com.zhu.util.code;

public enum ResultCode {

  /* 成功 */
  SUCCESS(200,"成功");

  private Integer code;
  private String message;

  private ResultCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer code() {
    return this.code;
  }

  public String message() {
    return this.message;
  }

}
