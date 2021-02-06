package com.devada.admin.constants;

import org.springframework.http.HttpStatus;

import com.devada.base.exception.ResultCode;

public enum AdminSuccessCode implements ResultCode {

  CATEGORY_SAVE_SUCCESS(30001, "Category saved successfully", HttpStatus.OK.value()),
  CATEGORY_GET_SUCCESS(30002, "Category fetched successfully", HttpStatus.OK.value()),
  CATEGORY_DELETE_SUCCESS(30003, "Category deleted successfully", HttpStatus.OK.value());

  private final int httpStatus;
  private final int resultCode;
  private final String message;

  AdminSuccessCode(int resultCode, String message, int httpStatus) {
    this.httpStatus = httpStatus;
    this.resultCode = resultCode;
    this.message = message;

  }

  @Override
  public int getResultCode() {
    return resultCode;
  }

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public int getHttpStatus() {
    return httpStatus;
  }

}
