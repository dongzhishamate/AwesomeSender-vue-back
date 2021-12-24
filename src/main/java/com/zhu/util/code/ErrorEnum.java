package com.zhu.util.code;

public enum ErrorEnum {
  // 数据操作错误定义
  SUCCESS("200", "nice"),
  NO_PERMISSION("403","你没得权限"),
  NO_AUTH("401","你能不能先登录一下"),
  NOT_FOUND("404", "未找到该资源!"),
  INTERNAL_SERVER_ERROR("500", "服务器跑路了"),

  //用户登录注册
  USER_EXIST("1001", "用户名已存在")
  ;

  /** 错误码 */
  private String errorCode;

  /** 错误信息 */
  private String errorMsg;

  ErrorEnum(String errorCode, String errorMsg) {
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }
}
