package com.devada.base.controller;

import javax.ws.rs.core.Response;

import com.devada.base.dto.ResponseDetailDto;
import com.devada.base.dto.ReturnMessageDto;
import com.devada.base.dto.UiApiResponseDto;
import com.devada.base.enumeration.ResponseCode;
import com.devada.base.enumeration.ResponseMessageType;
import com.devada.base.exception.KKException;

/**
 * Base class used for some generic methods
 * 
 * @author KHODBHAYA
 */
public class BaseController {

  /**
   * This method is used to set error into ReturnMessageDto base on resultCode.
   * 
   * @param uiApiResponseDto
   *          contains the code and message.
   * @param returnMessageDto
   *          {@link ReturnMessageDto} contains the code and message.
   * @param <T>
   *          type of return object.
   */
  protected <T> void setErrorResult(UiApiResponseDto<T> uiApiResponseDto,
      ReturnMessageDto returnMessageDto) {
    returnMessageDto.setResultCode(uiApiResponseDto.getCode());
    returnMessageDto.setMessageKey(uiApiResponseDto.getMessage());
    returnMessageDto.setResponseDetail(uiApiResponseDto.getResponseDetail());
  }

  /**
   * This method is used to set ApiResponseDto
   * 
   * @param returnObject
   *          {@link Object} result object
   * @param returnMessageDto
   *          {@link ReturnMessageDto} message details
   * @param responseDetailDto
   *          {@link ResponseDetailDto} response details
   */
  protected void setResult(Object returnObject, ReturnMessageDto returnMessageDto,
      ResponseDetailDto responseDetailDto) {

    // set api response
    returnMessageDto.setResultCode(ResponseCode.SUCCESS.getCode());
    returnMessageDto.setMessageKey(ResponseMessageType.SUCCESS.toString());

    // set content
    returnMessageDto.setReturnObject(returnObject);

    // set response details
    returnMessageDto.setResponseDetail(responseDetailDto);
  }

  /**
   * This method is used to handle exception.
   * 
   * 
   * @param returnMessageDto
   *          {@link ReturnMessageDto} contains the status, code and message.
   * @param exception
   *          {@link ZodiacException} reference to exception.
   * @param t
   *          {@link T} contains natural object.
   * @param <T>
   *          type of return object.
   */
  protected <T> void handleZodiacException(ReturnMessageDto returnMessageDto,
      KKException exception, T t) {

    // set response
    int firstDigit = Integer.parseInt(String.valueOf(String.valueOf(exception.getErrorCode())
        .charAt(0)));
    switch (firstDigit) {
      case 1: // System Exception
        returnMessageDto.setResultCode(ResponseCode.SYSTEM.getCode());
        break;
      case 2: // Business Exception
        returnMessageDto.setResultCode(ResponseCode.BUSINESS.getCode());
        break;
      case 4: // Database Exception
        returnMessageDto.setResultCode(ResponseCode.DAO_DATABASE.getCode());
        break;
      case 5: // Communication Exception
        returnMessageDto.setResultCode(ResponseCode.COMMUNICATION.getCode());
        break;
      case 6: // IO Exception
        returnMessageDto.setResultCode(ResponseCode.IO_FILE.getCode());
        break;
      default: // As of now treating all unqualified exceptions fall under
               // system exception
        returnMessageDto.setResultCode(ResponseCode.SYSTEM.getCode());
        break;
    }
    returnMessageDto.setMessageKey(ResponseMessageType.ERROR.toString());
    returnMessageDto.setReturnObject(t);
    // set response details
    ResponseDetailDto responseDetailDto = new ResponseDetailDto();

    returnMessageDto.setResponseDetail(responseDetailDto);
  }

  /**
   * This method is use to set validation response
   * 
   * @param returnMsgDto
   *          {@link ReturnMessageDto} response details
   * @param responseDetailDto
   *          {@link ResponseDetailDto} response details
   * 
   */
  protected void setValidationResult(ReturnMessageDto returnMsgDto,
      ResponseDetailDto responseDetailDto) {

    returnMsgDto.setResultCode(ResponseCode.BUSINESS.getCode());
    returnMsgDto.setMessageKey(ResponseMessageType.VALIDATION.toString());
    returnMsgDto.setResponseDetail(responseDetailDto);
  }

  /**
   * This method is used to check the status of web api request
   * 
   * @param response
   *          {@link UiApiResponseDto} contains response object
   * @return {@link Boolean} returns true if web api request successful
   */
  protected static boolean isSuccess(UiApiResponseDto<?> response) {
    return Response.Status.Family.SUCCESSFUL.equals(Response.Status.fromStatusCode(
        response.getStatus()).getFamily());
  }
}
