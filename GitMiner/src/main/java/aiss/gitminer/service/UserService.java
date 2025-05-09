package aiss.gitminer.service;

import java.util.List;
import java.util.ArrayList;
import aiss.gitminer.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    List<User> users = new ArrayList<>(); // List of imported User objects
    public List<User> getUsers() {
        return users;
    }
    public User getUser(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null); // o lanzar una excepción si no se encuentra el usuario
    }
    public User createUser(User user) {
        users.add(user);
        return user;
    }
    public void createUsers(List<User> users) {
        this.users.addAll(users);
    }

}