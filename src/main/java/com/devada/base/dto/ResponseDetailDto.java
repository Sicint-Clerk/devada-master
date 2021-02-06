package com.devada.base.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.devada.base.exception.ResultCode;

/**
 * This class is used for conversion of json to pojo and vice versa. for exception handling
 */
public class ResponseDetailDto extends BaseDto {
  private static final long serialVersionUID = 1L;

  private List<ResponseObjectDto> errorDetail;
  private List<ResponseObjectDto> warningDetail; // SUCCESS
  private List<ResponseObjectDto> validationDetail;
  private List<ResponseObjectDto> infoDetail; // SUCCESS
  private List<ResponseObjectDto> successDetail; // SUCCESS

  // getters and setters
  public List<ResponseObjectDto> getErrorDetail() {
    if (CollectionUtils.isEmpty(errorDetail)) {
      errorDetail = new ArrayList<ResponseObjectDto>();
    }
    return errorDetail;
  }

  public List<ResponseObjectDto> getWarningDetail() {
    if (CollectionUtils.isEmpty(warningDetail)) {
      warningDetail = new ArrayList<ResponseObjectDto>();
    }
    return warningDetail;
  }

  public List<ResponseObjectDto> getValidationDetail() {
    if (CollectionUtils.isEmpty(validationDetail)) {
      validationDetail = new ArrayList<ResponseObjectDto>();
    }
    return validationDetail;
  }

  public List<ResponseObjectDto> getInfoDetail() {
    if (CollectionUtils.isEmpty(infoDetail)) {
      infoDetail = new ArrayList<ResponseObjectDto>();
    }
    return infoDetail;
  }

  public List<ResponseObjectDto> getSuccessDetail() {
    if (CollectionUtils.isEmpty(successDetail)) {
      successDetail = new ArrayList<ResponseObjectDto>();
    }
    return successDetail;
  }

  public void addErrorDetail(String field, ResultCode result) {
    getErrorDetail().add(new ResponseObjectDto(field, result));
  }

  public void addWarningDetail(String field, ResultCode result) {
    getWarningDetail().add(new ResponseObjectDto(field, result));
  }

  public void addValidationDetail(String field, ResultCode result) {
    getValidationDetail().add(new ResponseObjectDto(field, result));
  }

  public void addInfoDetail(String field, ResultCode result) {
    getInfoDetail().add(new ResponseObjectDto(field, result));
  }

  public void addSuccessDetail(String field, ResultCode result) {
    getSuccessDetail().add(new ResponseObjectDto(field, result));
  }

  @Override
  public String toString() {
    return String
        .format("ResponseDetailDto [errorDetail=%s, warningDetail=%s, validationDetail=%s, infoDetail=%s, successDetail=%s]",
            errorDetail, warningDetail, validationDetail, infoDetail, successDetail);
  }

}
