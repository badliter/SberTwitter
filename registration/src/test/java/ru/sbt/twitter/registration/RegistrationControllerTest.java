package ru.sbt.twitter.registration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import ru.sbt.twitter.registration.model.Status;
import ru.sbt.twitter.registration.model.User;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.http.HttpStatus.OK;

@SpringBootTest
public class RegistrationControllerTest {
    @Test
    public void signUpTest() throws URISyntaxException {
        RestTemplate template = new RestTemplate();
        User user = new User();
        user.setStatus(Status.NOT_ACTIVE);
        user.setEmail("someEmail@sbt.olololo");
        user.setUsername("someNewUser");
        user.setId(5L);
        user.setPassword("password");
        user.setFirstName("FirstName");
        user.setLastName("LastName");

        RequestEntity<User> request = RequestEntity
                .post(new URI("http://localhost:8080/signUp"))
                .accept(MediaType.APPLICATION_JSON)
                .body(user);
        ResponseEntity<User> response = template.exchange(request, User.class);
    }
}