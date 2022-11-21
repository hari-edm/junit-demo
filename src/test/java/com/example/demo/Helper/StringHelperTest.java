package com.example.demo.Helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StringHelperTest {

  // AACD => CD ACD => CD CDEF=>CDEF CDAA => CDAA

  static StringHelper helper;

  @BeforeAll
  public static void before() {
    helper = new StringHelper();
  }

  @Test
  public void testTruncateAInFirst2PositionsAinFirst2Positions() {
    // given
    String input = "AACD";
    // when
    String result = helper.truncateAInFirst2Positions(input);
    // then
    Assertions.assertEquals("CD", result);
  }

  @Test
  public void testTruncateAInFirst2PositionsAinFirstPosition() {
    // given
    String input = "ACD";
    // when
    String result = helper.truncateAInFirst2Positions(input);
    // then
    Assertions.assertEquals("CD", result);
  }

  // ABCD => false, ABAB => true, AB => true, A => false
  @Test
  public void testAreFirstAndLastTwoCharactersTheSameBasicNegativeScenario() {

    // given
    String input = "ABCD";
    // when
    boolean result = helper.areFirstAndLastTwoCharactersTheSame(input);
    // then
    Assertions.assertFalse(result);
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSameBasicPositiveScenario() {
    // given
    String input = "ABAB";
    // when
    boolean result = helper.areFirstAndLastTwoCharactersTheSame(input);
    // then
    Assertions.assertTrue(result);
  }
}
