package com.devada.base.config;

import java.lang.reflect.Type;

import com.google.gson.Gson;

public class CommonUtil {

  private static Gson gson = new Gson();

  /**
   * This method is used to get pojo from json
   * 
   * @param jsonString
   *          {@link String} contains jsonString.
   * @param classType
   *          {@link Class} contains class type.
   * @param <T>
   *          contains json
   * @return T
   */
  public static <T> T getPojoFromJson(String jsonString, Class<T> classType) {
    T t = gson.fromJson(jsonString, classType);
    return t;
  }

  /**
   * This method is used to get pojo from json
   * 
   * Please catch JsonSyntaxException at controller layer from where this method directly/indirectly called.
   * 
   * @param jsonString
   *          {@link String} contains jsonString.
   * @param type
   *          {@link Type} contains type.
   * @param <T>
   *          contains json
   * @return T contains json
   */
  public static <T> T getPojoFromJson(String jsonString, Type type) {
    T t = gson.fromJson(jsonString, type);
    return t;
  }

  /**
   * This method is used to get json from pojo
   * 
   * Please catch JsonSyntaxException at controller layer from where this method directly/indirectly called.
   * 
   * @param src
   *          {@link Object} contains jsonString.
   * @return T contains json
   */
  public static <T> String getJsonFromPojo(Object src) {
    String json = gson.toJson(src);
    return json;
  }
}
