package com.devada.base.exception;


/**
 * Base Class to handle runtime exception. This class is used if a method does not throw any subclass of KKException and
 * there is large impact if we need to change all caller method signature. Then, we may through KKRuntimeException.
 *
 */
public class KKRuntimeException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private int httpStatus;
  private int errorCode;
  private int severityType = 1;
  private String[] msgArgs;

  /**
   * Constructor with only errorCode and message
   * 
   * @param errorCode
   *          {@link Integer} contain code
   * @param message
   *          {@link String} contain error message
   * 
   */
  public KKRuntimeException(int errorCode, String message) {
    super(message);

    this.errorCode = errorCode;
  }

  /**
   * Constructor with only errorCode and message and http code.
   * 
   * @param errorCode
   *          {@link Integer} contain code
   * @param message
   *          {@link String} contain error message
   * @param httpStatus
   *          {@link Integer} contain http type code
   * 
   */
  public KKRuntimeException(int errorCode, String message, int httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
    this.errorCode = errorCode;
  }

  /**
   * Constructor with only errorCode and message and severity type and http code.
   * 
   * @param errorCode
   *          {@link Integer} contain code
   * @param message
   *          {@link String} contain error message
   * @param severityType
   *          {@link Integer} contain severity type code
   * @param httpStatus
   *          {@link Integer} contain http type code
   * 
   */
  public KKRuntimeException(int errorCode, String message, int severityType, int httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
    this.errorCode = errorCode;
    this.severityType = severityType;
  }

  /**
   * Constructor with errorCode, message and call stack
   * 
   * @param errorCode
   *          {@link Integer} contain code
   * @param message
   *          {@link String} contain error message
   * @param httpStatus
   *          {@link Integer} contain http type code
   * @param cause
   *          {@link Throwable} contain error cause
   * @param httpStatus
   *          {@link Integer} contain http status code
   * 
   */
  public KKRuntimeException(int errorCode, String message, int httpStatus, Throwable cause) {
    super(message, cause);

    this.httpStatus = httpStatus;
    this.errorCode = errorCode;
  }

  /**
   * Constructor with only resultCode
   * 
   * @param resultCode
   *          {@link Integer} contain result code
   * 
   */
  public KKRuntimeException(ResultCode resultCode) {
    this(resultCode.getResultCode(), resultCode.getMessage(), resultCode.getHttpStatus());
  }

  /**
   * Constructor with errorCode, message, service type, http code and call stack
   * 
   * @param errorCode
   *          {@link Integer} contain code
   * @param message
   *          {@link String} contain error message
   * @param severityType
   *          {@link Integer} contain severity type code
   * @param httpStatus
   *          {@link Integer} contain http type code
   * @param cause
   *          {@link Throwable} contain error cause
   * 
   */
  public KKRuntimeException(int errorCode, String message, int severityType, int httpStatus,
      Throwable cause) {
    super(message, cause);

    this.httpStatus = httpStatus;
    this.errorCode = errorCode;
    this.severityType = severityType;
  }

  /**
   * Constructor with errorCode, message and message arguments
   * 
   * @param errorCode
   *          {@link Integer} contain code
   * @param message
   *          {@link String} contain error message
   * @param httpStatus
   *          {@link Integer} contain http type code
   * @param msgArgs
   *          {@link String} contain error message arguments
   */
  public KKRuntimeException(int errorCode, String message, int httpStatus, String[] msgArgs) {
    super(message);
    this.errorCode = errorCode;
    this.httpStatus = httpStatus;

    if (msgArgs.length > 0) {
      this.msgArgs = msgArgs;
    }
  }

  /**
   * Constructor with errorCode, message, severity type and message arguments
   * 
   * @param errorCode
   *          {@link Integer} contain code
   * @param message
   *          {@link String} contain error message
   * @param severityType
   *          {@link Integer} contain severity type code
   * @param httpStatus
   *          {@link Integer} contain http type code
   * @param msgArgs
   *          {@link String} contain error message arguments
   */
  public KKRuntimeException(int errorCode, String message, int severityType, int httpStatus,
      String[] msgArgs) {
    super(message);
    this.httpStatus = httpStatus;
    this.errorCode = errorCode;
    this.severityType = severityType;

    if (msgArgs.length > 0) {
      this.msgArgs = msgArgs;
    }
  }

  /**
   * Constructor with errorCode, message, call Stack and message arguments
   * 
   * @param errorCode
   *          {@link Integer} contain code
   * @param message
   *          {@link String} contain error message
   * @param httpStatus
   *          {@link int} contain the http status
   * @param cause
   *          {@link Throwable} contain error cause
   * @param msgArgs
   *          {@link String} contain error message arguments
   */
  public KKRuntimeException(int errorCode, String message, int httpStatus, Throwable cause,
      String[] msgArgs) {
    super(message, cause);
    this.errorCode = errorCode;
    this.httpStatus = httpStatus;

    if (msgArgs != null && msgArgs.length > 0) {
      this.msgArgs = msgArgs;
    }
  }

  /**
   * Constructor with errorCode, message, severitz, http status, call Stack and message arguments
   * 
   * @param errorCode
   *          {@link Integer} contain code
   * @param message
   *          {@link String} contain error message
   * @param severityType
   *          {@link Integer} contain severity type
   * @param httpStatus
   *          {@link int} contain the http status
   * @param cause
   *          {@link Throwable} contain error cause
   * @param msgArgs
   *          {@link String} contain error message arguments
   */
  public KKRuntimeException(int errorCode, String message, int severityType, int httpStatus,
      Throwable cause, String[] msgArgs) {
    super(message, cause);
    this.errorCode = errorCode;
    this.httpStatus = httpStatus;
    this.severityType = severityType;
    if (msgArgs != null && msgArgs.length > 0) {
      this.msgArgs = msgArgs;
    }
  }

  public int getHttpStatus() {
    return httpStatus;
  }

  public int getErrorCode() {
    return this.errorCode;
  }

  public int getSeverityType() {
    return this.severityType;
  }

  public String getErrorMessage() {
    return null;
  }

  public String getErrorMessageKey() {
    return String.valueOf(this.errorCode);
  }

  public String[] getMsgArgs() {
    return msgArgs;
  }

}
