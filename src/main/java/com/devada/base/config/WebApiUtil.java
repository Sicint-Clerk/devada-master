package com.devada.base.config;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class WebApiUtil {

  /**
   * This method is used to call web service based on url.
   * 
   * @param fullUrl
   *          {@link String} contains full url of api
   * 
   * @return {@link String} contains json response
   */
  public static String get(String fullUrl) {
    String jsonResoponse = null;
    try {
      Client client = Client.create();
      WebResource webResource = null;
      webResource = client.resource(fullUrl);
      webResource.accept(MediaType.APPLICATION_JSON);

      Builder webBuilder = webResource.type(MediaType.APPLICATION_JSON);
      ClientResponse response = webBuilder.type(MediaType.APPLICATION_JSON).get(
          ClientResponse.class);
      jsonResoponse = response.getEntity(String.class);
      response.close();
      client.destroy();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return jsonResoponse;
  }

  /**
   * This method is used to call web service based on url.
   * 
   * @param fullUrl
   *          {@link String} contains full url of api
   * 
   * @param fullUrl
   *          {@link String} contains full url of api
   * 
   * @return {@link String} contains json response
   */
  public static String post(String fullUrl, Object requestData) {
    String jsonResoponse = null;
    try {
      Client client = Client.create();
      WebResource webResource = null;
      webResource = client.resource(fullUrl);
      webResource.accept(MediaType.APPLICATION_JSON);

      String data = CommonUtil.getJsonFromPojo(requestData);

      Builder webBuilder = webResource.type(MediaType.APPLICATION_JSON);
      ClientResponse response = webBuilder.type(MediaType.APPLICATION_JSON).post(
          ClientResponse.class, data);

      jsonResoponse = response.getEntity(String.class);
      response.close();
      client.destroy();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return jsonResoponse;
  }
}
