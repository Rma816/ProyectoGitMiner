package aiss.githubminer.service;

import aiss.githubminer.model.UserGHM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public UserGHM getUser(String username) {
        try {
            String url = "https://api.github.com/users/" + username;
            return restTemplate.getForObject(url, UserGHM.class);
        } catch (Exception e) {
            System.err.println("Failed to obtain the user: " + e.getMessage());
            return null;
        }
    }
}
