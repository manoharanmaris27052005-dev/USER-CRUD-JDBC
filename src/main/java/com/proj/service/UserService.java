
package com.proj.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.dao.UserDao;
import com.proj.entity.User;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao dao;

    public void addUser(User user) {
        dao.saveUser(user);
    }

    public User getUser(int id) {
        return dao.getUser(id);
    }

    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }

    public void saveAll(List<User> users) {
        dao.saveAll(users);   // ✅ FIXED
    }
}