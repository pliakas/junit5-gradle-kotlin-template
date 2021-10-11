package org.roukou.junit5.gradle;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Helper {

  /**
      * Create a list containing class and all its super classes.
     */
  public static List<Class<?>> getClassesOf(Class<?> origin) {

    return  Stream.<Class<?>>iterate(origin, Class::getSuperclass)
        .takeWhile(Objects::nonNull)
        .collect(Collectors.toList());
  }
}
