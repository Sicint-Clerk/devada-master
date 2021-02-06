package com.devada.admin.constants;

import org.springframework.http.HttpStatus;

import com.devada.base.exception.ResultCode;

public enum AdminErrorCodes implements ResultCode {
  /* SYSTEM EXCEPTION : START */
  ADMIN_CONTROLLER_CATEGORY_SAVE_EXCEPTION(10001, "Category can not be save", HttpStatus.BAD_REQUEST.value()),
  ADMIN_SERVICE_CATEGORY_SAVE_EXCEPTION(10002, "Category can not be save", HttpStatus.BAD_REQUEST.value()),
  ADMIN_SERVICE_SUB_CATEGORY_SAVE_EXCEPTION(10003, "Sub Category can not be save", HttpStatus.BAD_REQUEST.value()),
  ADMIN_CONTROLLER_SUB_CATEGORY_SAVE_EXCEPTION(10004, "Sub Category can not be save", HttpStatus.BAD_REQUEST.value()),
  ADMIN_CONTROLLER_CATEGORY_GET_EXCEPTION(10005, "Category can not be get", HttpStatus.BAD_REQUEST.value()),
  ADMIN_CONTROLLER_CATEGORY_DELETE_EXCEPTION(10006, "Category can not be delete", HttpStatus.BAD_REQUEST.value()),
  ADMIN_SERVICE_CATEGORY_GET_EXCEPTION(10007, "Category can not be get", HttpStatus.BAD_REQUEST.value()),
  ADMIN_SERVICE_CATEGORY_DELETE_EXCEPTION(10008, "Category can not be delete", HttpStatus.BAD_REQUEST.value()),
  ADMIN_SERVICE_SUB_CATEGORY_GET_EXCEPTION(10009, "Sub Category can not be get", HttpStatus.BAD_REQUEST.value()),
  ADMIN_CONTROLLER_SUB_CATEGORY_GET_EXCEPTION(10010, "Category can not be get", HttpStatus.BAD_REQUEST.value()),
  /* SYSTEM EXCEPTION : END */

  /* VALIDATION : START */
  ADMIN_VALIDATION_CATEGORY_SAVE_NOT_FOUND(20001, "Category can not be found", HttpStatus.BAD_REQUEST.value()),
  ADMIN_VALIDATION_CATEGORY_SAVE_NAME_NOT_FOUND(20002, "Name can not be found", HttpStatus.BAD_REQUEST.value()),
  ADMIN_VALIDATION_SUB_CATEGORY_SAVE_NOT_FOUND(20003, "Sub Category can not be found", HttpStatus.BAD_REQUEST.value()),
  ADMIN_VALIDATION_SUB_CATEGORY_SAVE_NAME_NOT_FOUND(20004, "Name can not be found", HttpStatus.BAD_REQUEST.value()),
  ADMIN_VALIDATION_CATEGORY_DELETE_KEY_NOT_FOUND(20005, "key can not be found", HttpStatus.BAD_REQUEST.value()),
  ADMIN_VALIDATION_CATEGORY_DELETE_NOT_FOUND(20006, "Category can not be found", HttpStatus.BAD_REQUEST.value()),
  /* VALIDATION : END */

  /* DAO : START */
  ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_STATE_EXCEPTION(40001, "Unable to complete your request", HttpStatus.BAD_REQUEST.value()),
  ADMIN_DAO_CATEGORY_SAVE_ILLEGAL_ARGUMENT_EXCEPTION(40002, "Unable to complete your request", HttpStatus.BAD_REQUEST.value()),
  ADMIN_DAO_SUB_CATEGORY_SAVE_ILLEGAL_STATE_EXCEPTION(40003, "Unable to complete your request", HttpStatus.BAD_REQUEST.value()),
  ADMIN_DAO_SUB_CATEGORY_SAVE_ILLEGAL_ARGUMENT_EXCEPTION(40004, "Unable to complete your request", HttpStatus.BAD_REQUEST.value()),
  ADMIN_DAO_CATEGORY_GET_ILLEGAL_STATE_EXCEPTION(40005, "Unable to complete your request", HttpStatus.BAD_REQUEST.value()),
  ADMIN_DAO_CATEGORY_GET_ILLEGAL_ARGUMENT_EXCEPTION(40006, "Unable to complete your request", HttpStatus.BAD_REQUEST.value()),
  ADMIN_DAO_CATEGORY_DELETE_ILLEGAL_STATE_EXCEPTION(40007, "Unable to complete your request", HttpStatus.BAD_REQUEST.value()),
  ADMIN_DAO_CATEGORY_DELETE_ILLEGAL_ARGUMENT_EXCEPTION(40008, "Unable to complete your request", HttpStatus.BAD_REQUEST.value()),
  ADMIN_DAO_SUB_CATEGORY_GET_ILLEGAL_STATE_EXCEPTION(40009, "Unable to complete your request", HttpStatus.BAD_REQUEST.value()),
  ADMIN_DAO_SUB_CATEGORY_GET_ILLEGAL_ARGUMENT_EXCEPTION(40010, "Unable to complete your request", HttpStatus.BAD_REQUEST.value());
  /* DAO : END */


  private final int httpStatus;
  private final int resultCode;
  private final String message;

  AdminErrorCodes(int resultCode, String message, int httpStatus) {
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
