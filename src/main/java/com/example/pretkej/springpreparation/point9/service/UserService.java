package com.example.pretkej.springpreparation.point9.service;

import com.example.pretkej.springpreparation.point9.exception.NotFound;
import com.example.pretkej.springpreparation.point9.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();
    private static int id = 2;
    @PostConstruct
    public void init() {
        userList.add(new User(0, "Irena", "Santor", "Santi", 1450));
        userList.add(new User(1, "Piotr", "Emeryt", "emeri", 1));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(Integer id) throws NotFound {
        return userList.stream().filter(user -> user.getId() == id).findFirst().orElseThrow(NotFound::new);
    }

    public User addUser(User user) {
        user.setId(id++);
        userList.add(user);
        return user;
    }

    public User updateUser(Integer id, User user) throws NotFound {
        User user2 = userList.stream().filter(user1 -> user1.getId() == id).findFirst().orElseThrow(NotFound::new);
        user2.setBirthYear(user.getBirthYear());
        user2.setName(user.getName());
        user2.setLogin(user.getLogin());
        user2.setPassword(user2.getPassword());
        return user2;
    }

    public User deleteUser(Integer id) throws NotFound {
        User user2 = userList.stream().filter(user1 -> user1.getId() == id).findFirst().orElseThrow(NotFound::new);
        userList.remove(user2);
        return user2;
    }

    public List<User> filterByBirthYear(List<User> allUsers, Integer birthYear) {
        return allUsers.stream().filter(user -> user.getBirthYear() == birthYear).collect(Collectors.toList());
    }
}
