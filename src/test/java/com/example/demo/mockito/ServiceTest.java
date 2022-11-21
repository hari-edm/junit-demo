package com.example.demo.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

  @Mock
  UserDao dao;

  @InjectMocks
  UserService service;

  @Captor ArgumentCaptor<User> captor;

  @Test
  public void testQuery() {

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
