package com.example.demo.spring;

import com.example.demo.mockito.User;
import com.example.demo.mockito.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringUserService {

    @Autowired
    private SpringUserDao dao;



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
