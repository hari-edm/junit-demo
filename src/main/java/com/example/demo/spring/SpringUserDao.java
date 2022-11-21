package com.example.demo.spring;


import com.example.demo.mockito.User;
import org.springframework.stereotype.Repository;

@Repository
public class SpringUserDao {
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
