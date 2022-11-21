package com.example.demo.mockito;

public class UserDao {

  public boolean isAvailable() {

    return false;
  }

  public int getUniqueId() {
    return 42;
  }

  public String getUserName(int userId) {
    return "test-name";
  }

  public String getUserEmailId(User user) {
    return "test-name@gmail.com";
  }
}
