package at.saunders.userapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return (List<User>) userService.findAll();
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        if (user.getId() == null) {
            user.setId(user.getName().toLowerCase());
        }
        userService.save(user);
    }

}
