package com.example.demo.mockito;

public class UserService {

  private UserDao dao;

  public UserService(UserDao database) {
    this.dao = database;
  }

  public boolean query(String query) {
    return dao.isAvailable();
  }

  public String getUserName(int id) {
    return dao.getUserName(id);
  }

  public String getUserEmailId(int userId) {
    User user = new User(userId);
    return dao.getUserEmailId(user);
  }
}
