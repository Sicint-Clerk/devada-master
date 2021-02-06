package com.devada.base.config;

import org.apache.commons.lang3.StringUtils;

public class WebApiController extends WebApiUtil {

  public static String getAdminWebApi(String apiSuffix) {
    return get(FrameworkWebApiUriMapping.REPOSITORY_MAPPING + FrameworkWebApiUriMapping.ADMIN_API_CONFIG
        + (StringUtils.isNotBlank(apiSuffix) ? apiSuffix : ""));
  }

  public static String postAdminWebApi(String apiSuffix, Object requestData) {
    return post(FrameworkWebApiUriMapping.REPOSITORY_MAPPING + FrameworkWebApiUriMapping.ADMIN_API_CONFIG
        + ((StringUtils.isNotBlank(apiSuffix)) ? apiSuffix : ""), requestData);
  }
}
