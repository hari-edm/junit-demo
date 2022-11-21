package com.example.demo.spring;

import com.example.demo.mockito.User;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
class SpringUserServiceTest {

  @Autowired SpringUserService service;

  @MockBean SpringUserDao dao;

  @Captor ArgumentCaptor<User> captor;

  @Test
  void testQuery() {
    // given
    when(dao.isAvailable()).thenReturn(true);
    // Service service = new Service(dao);
    // when
    boolean result = service.query("dummy");
    // then
    assertTrue(result);
    verify(dao, times(1)).isAvailable();
  }

  @Test
  public void testGetUserNameByUserId() {

    // given
    String expectedUserName = "test-user";
    when(dao.getUserName(10)).thenReturn(expectedUserName);
    // Service service = new Service(dao);
    // when
    String result = service.getUserName(10);
    // then
    assertEquals(expectedUserName, result);
    verify(dao, times(1)).getUserName(10);
  }

  @Test
  public void testGetUserEmailId() {
    // given
    String expectedEmailId = "test-mail@gmail.com";
    when(dao.getUserEmailId(any(User.class))).thenReturn(expectedEmailId);
    // when
    String result = service.getUserEmailId(10);
    // then
    assertEquals(expectedEmailId, result);
    verify(dao, times(1)).getUserEmailId(any(User.class));
  }

  @Test
  public void testGetUserEmailIdByArgMatcher() {
    // given
    String expectedEmailId = "test-mail@gmail.com";
    BDDMockito.given(dao.getUserEmailId(argThat(arg -> arg.getUserId() == 10)))
        .willReturn(expectedEmailId);
    // when
    String result = service.getUserEmailId(10);
    // then
    assertEquals(expectedEmailId, result);
    verify(dao).getUserEmailId(any(User.class));
  }

  @Test
  public void testGetUserEmailIdByArgCapture() {
    // given
    String expectedEmailId = "test-mail@gmail.com";
    BDDMockito.given(dao.getUserEmailId(captor.capture())).willReturn(expectedEmailId);
    // when
    String result = service.getUserEmailId(10);
    // then
    assertEquals(expectedEmailId, result);
    verify(dao).getUserEmailId(any(User.class));
    assertEquals(10, captor.getValue().getUserId());
  }
}
