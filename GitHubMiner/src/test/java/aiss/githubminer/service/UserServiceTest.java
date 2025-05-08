package aiss.githubminer.service;

import aiss.githubminer.model.UserGHM;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("Get a GitHub user - 1")
    void getUser() {
        // Datos de entrada
        String username = "octocat";

        // Ejecución
        UserGHM user = userService.getUser(username);

        // Aserciones
        assertNotNull(user, "El usuario no debería ser nulo");
        assertNotNull(user.getLogin(), "El usuario debe tener un login");
        assertEquals("octocat", user.getLogin(), "El login del usuario debe ser 'octocat'");

        System.out.println("Usuario: " + user.getLogin());
        System.out.println("ID del usuario: " + user.getId());
        System.out.println("Usuario octocat: \n" + user);
    }
}