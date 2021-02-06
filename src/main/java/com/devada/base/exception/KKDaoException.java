package com.devada.base.exception;

/**
 * Exception class to handle DAO exception
 */
public class KKDaoException extends KKSystemException {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor with only resultCode
   * 
   * @param resultCode
   *          {@link Integer} contain result code
   */
  public KKDaoException(ResultCode resultCode) {
    super(resultCode);
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
  public KKDaoException(ResultCode resultCode, int severityType) {
    super(resultCode, severityType);
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
  public KKDaoException(ResultCode resultCode, Throwable cause) {
    super(resultCode, cause);
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
  public KKDaoException(ResultCode resultCode, int severityType, Throwable cause) {
    super(resultCode, severityType, cause);
  }

  /**
   * Constructor with resultCode and message arguments
   * 
   * @param resultCode
   *          {@link Integer} contain result code
   * @param msgArgs
   *          {@link String} contain error message arguments
   */
  public KKDaoException(ResultCode resultCode, String... msgArgs) {
    super(resultCode, msgArgs);
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
  public KKDaoException(ResultCode resultCode, int severityType, String... msgArgs) {
    super(resultCode, severityType, msgArgs);
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
  public KKDaoException(ResultCode resultCode, Throwable cause, String... msgArgs) {
    super(resultCode, cause, msgArgs);
  }
}
