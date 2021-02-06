package com.devada.base.exception;

/**
 * Exception class to handle system exception
 */
public class KKSystemException extends KKException {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor with only resultCode
   * 
   * @param resultCode
   *          {@link Integer} contain result code
   */
  public KKSystemException(ResultCode resultCode) {
    super(resultCode.getResultCode(), resultCode.getMessage(), resultCode.getHttpStatus());
  }

  /**
   * Constructor with only resultCode and severity type
   * 
   * @param resultCode
   *          {@link Integer} contain result code
   * @param severityType
   *          {@link Integer} contain severity type code
   * 
   */
  public KKSystemException(ResultCode resultCode, int severityType) {
    super(resultCode.getResultCode(), resultCode.getMessage(), severityType, resultCode
        .getHttpStatus());
  }

  /**
   * Constructor with resultCode and call stack
   * 
   * @param resultCode
   *          {@link Integer} contain result code
   * @param cause
   *          {@link Throwable} contain error cause
   * 
   */
  public KKSystemException(ResultCode resultCode, Throwable cause) {
    super(resultCode.getResultCode(), resultCode.getMessage(), resultCode.getHttpStatus(),
        cause);
  }

  /**
   * Constructor with resultCode and call stack
   * 
   * @param resultCode
   *          {@link Integer} contain result code
   * @param severityType
   *          {@link Integer} contain severity type code
   * @param cause
   *          {@link Throwable} contain error cause
   * 
   */
  public KKSystemException(ResultCode resultCode, int severityType, Throwable cause) {
    super(resultCode.getResultCode(), resultCode.getMessage(), severityType, resultCode
        .getHttpStatus(), cause);
  }

  /**
   * Constructor with resultCode and message arguments
   * 
   * @param resultCode
   *          {@link Integer} contain result code
   * @param msgArgs
   *          {@link String} contain error message arguments
   */
  public KKSystemException(ResultCode resultCode, String... msgArgs) {
    super(resultCode.getResultCode(), resultCode.getMessage(), resultCode.getHttpStatus(),
        msgArgs);
  }

  /**
   * Constructor with resultCode, severity type and message arguments
   * 
   * @param resultCode
   *          {@link Integer} contain result code
   * @param severityType
   *          {@link Integer} contain severity type code
   * @param msgArgs
   *          {@link String} contain error message arguments
   */
  public KKSystemException(ResultCode resultCode, int severityType, String... msgArgs) {
    super(resultCode.getResultCode(), resultCode.getMessage(), severityType, resultCode
        .getHttpStatus(), msgArgs);
  }

  /**
   * Constructor with resultCode, call Stack and message arguments
   * 
   * @param resultCode
   *          {@link Integer} contain result code
   * @param cause
   *          {@link Throwable} contain error cause
   * @param msgArgs
   *          {@link String} contain error message arguments
   */
  public KKSystemException(ResultCode resultCode, Throwable cause, String... msgArgs) {
    super(resultCode.getResultCode(), resultCode.getMessage(), resultCode.getHttpStatus(),
        cause, msgArgs);
  }

  /**
   * Constructor with only resultCode and message
   * 
   * @param message
   *          {@link String} contain error message
   * @param resultCode
   *          {@link Integer} contain result code
   * 
   */
  public KKSystemException(String message, ResultCode resultCode) {
    super(resultCode.getResultCode(), message, resultCode.getHttpStatus());
  }
}
