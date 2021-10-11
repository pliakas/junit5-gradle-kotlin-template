package org.roukou.junit5.gradle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelperTest {

  @Test
  @DisplayName("Get all classes from Arraylist.class")
  void getClassesFrom() {

    // arrange
    Class<?> origin = ArrayList.class;

    // act
    var result = Helper.getClassesOf(origin);

    // assert
    assertEquals(
        List.of(ArrayList.class, AbstractList.class, AbstractCollection.class, Object.class),
        result);
  }
}