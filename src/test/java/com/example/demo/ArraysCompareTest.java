package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArraysCompareTest {

  @Test
  public void testArraySortRandomArray() {
    // given
    int[] numbers = {12, 3, 4, 1};
    int[] expected = {1, 3, 4, 12};
    // when
    Arrays.sort(numbers);
    // then
    Assertions.assertArrayEquals(expected, numbers);
  }
}
