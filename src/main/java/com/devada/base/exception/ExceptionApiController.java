package com.devada.base.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.devada.base.dto.ApiResponseDto;
import com.devada.base.dto.ResponseDetailDto;
import com.devada.base.enumeration.ResponseCode;
import com.devada.base.enumeration.ResponseMessageType;


public class ExceptionApiController {

  protected <T> void setResult(T t, int httpStatus, HttpServletResponse httpResponse,
      ApiResponseDto<T> apiResponseDto, ResponseDetailDto responseDetailDto) {
    // set response
    httpResponse.setStatus(httpStatus);

    // set api response
    apiResponseDto.setStatus(httpStatus);
    apiResponseDto.setCode(ResponseCode.SUCCESS.getCode());
    apiResponseDto.setMessage(ResponseMessageType.SUCCESS.toString());

    // set content
    apiResponseDto.setContent(t);

    // set response details
    apiResponseDto.setResponseDetail(responseDetailDto);
  }

  protected <T> void setValidationResult(HttpServletResponse response,
      ApiResponseDto<T> apiResponseDto, ResponseDetailDto responseDetailDto) {

    response.setStatus(HttpStatus.BAD_REQUEST.value());

    apiResponseDto.setStatus(HttpStatus.BAD_REQUEST.value());
    apiResponseDto.setCode(ResponseCode.BUSINESS.getCode());
    apiResponseDto.setMessage(ResponseMessageType.VALIDATION.toString());
    apiResponseDto.setResponseDetail(responseDetailDto);
  }

  protected <T> void handleException(HttpServletResponse response,
      ApiResponseDto<T> apiResponseDto, ResultCode resultCode, T t) {

    // set response
    response.setStatus(resultCode.getHttpStatus());

    // set api response : This code only handles Error Codes 9
    int firstDigit = Integer.parseInt(String.valueOf(String.valueOf(resultCode.getResultCode())
        .charAt(0)));
    switch (firstDigit) {
      case 1: // System Exception
        apiResponseDto.setCode(ResponseCode.SYSTEM.getCode());
        break;
      case 2: // Business Exception
        apiResponseDto.setCode(ResponseCode.BUSINESS.getCode());
        break;
      case 4: // Database Exception
        apiResponseDto.setCode(ResponseCode.DAO_DATABASE.getCode());
        break;
      case 5: // Communication Exception
        apiResponseDto.setCode(ResponseCode.COMMUNICATION.getCode());
        break;
      case 6: // IO Exception
        apiResponseDto.setCode(ResponseCode.IO_FILE.getCode());
        break;
      default: // As of now treating all unqualified exceptions fall under
               // system exception
        apiResponseDto.setCode(ResponseCode.SYSTEM.getCode());
        break;
    }

    apiResponseDto.setStatus(resultCode.getHttpStatus());
    apiResponseDto.setMessage(ResponseMessageType.ERROR.toString());

    // set content
    apiResponseDto.setContent(t);

    // set response details
    ResponseDetailDto responseDetailDto = new ResponseDetailDto();
    responseDetailDto.addErrorDetail(null, resultCode);
    apiResponseDto.setResponseDetail(responseDetailDto);
  }

  protected <T> void handleException(HttpServletResponse response,
      ApiResponseDto<T> apiResponseDto, KKException exception, T t) {

    // set response
    response.setStatus(exception.getHttpStatus());

    // set api response : This code only handles Error Codes 9
    int firstDigit = Integer.parseInt(String.valueOf(String.valueOf(exception.getErrorCode())
        .charAt(0)));
    switch (firstDigit) {
      case 1: // System Exception
        apiResponseDto.setCode(ResponseCode.SYSTEM.getCode());
        break;
      case 2: // Business Exception
        apiResponseDto.setCode(ResponseCode.BUSINESS.getCode());
        break;
      case 4: // Database Exception
        apiResponseDto.setCode(ResponseCode.DAO_DATABASE.getCode());
        break;
      case 5: // Communication Exception
        apiResponseDto.setCode(ResponseCode.COMMUNICATION.getCode());
        break;
      case 6: // IO Exception
        apiResponseDto.setCode(ResponseCode.IO_FILE.getCode());
        break;
      default: // As of now treating all unqualified exceptions fall under
               // system exception
        apiResponseDto.setCode(ResponseCode.SYSTEM.getCode());
        break;
    }

    apiResponseDto.setStatus(exception.getHttpStatus());
    apiResponseDto.setMessage(ResponseMessageType.ERROR.toString());

    // set content
    apiResponseDto.setContent(t);

    // set response details
    ResponseDetailDto responseDetailDto = new ResponseDetailDto();
    apiResponseDto.setResponseDetail(responseDetailDto);
  }
}
