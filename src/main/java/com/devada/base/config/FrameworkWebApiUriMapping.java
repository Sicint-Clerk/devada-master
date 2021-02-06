package com.devada.base.config;

/**
 * This interface is used to define all request web api uri mapping.
 * 
 * @author Food4u
 */
public interface FrameworkWebApiUriMapping {
  String REPOSITORY_MAPPING = "http://localhost:8080/forrestcorp";
  String FORWARD_SLASH = "/";
  String API_V1 = "/api/v1/";

  /* ADMIN URI : START */
  String ADMIN_API_CONFIG = API_V1 + "admin";
  /* ADMIN URI : END */
}
