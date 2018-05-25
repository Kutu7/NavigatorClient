package kg.almetico.transport.navigator;

import kg.almetico.transport.navigator.entity.User;
import kg.almetico.transport.navigator.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by kutu on 4/30/18.
 */
//curl -X POST http://localhost:8080/users/ -d '{"firstName":"Name","lastName":"Last name","username":"username","password":"123456","email":"email@gmail.com"}' -H "content-type:application/json"

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/users")
    public List<User> getUsers() {
        logger.info("User list requested...");
        return userRepository.findAll();
    }

    @PostMapping(path = "/users")
    public void createUser(@RequestBody User user) {
        logger.debug("Received: users:{}", user);
        userRepository.save(user);
    }

    @GetMapping(path = "users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/location")
    public ResponseEntity updateUser(@RequestBody UserLocation userLocation) {
        Optional<User> user = userRepository.findById(userLocation.getUserId());
        logger.info("location received {} {} {}", userLocation.getUserId(), userLocation.getLat(),userLocation.getLng());
        if (user.isPresent()) {
            User u = user.get();
            u.setLat(userLocation.getLat().toString());
            u.setLng(userLocation.getLng().toString());
            userRepository.save(u);
            return ResponseEntity.ok().build();
        }
        else {
            // bad request
            return ResponseEntity.notFound().build();
        }
    }
}
