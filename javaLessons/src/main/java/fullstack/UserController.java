package fullstack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/users")
    public Iterable<User> getUser() {
        return userRepo.findAll();
    }

    @PostMapping("/users")
    public User createUser(@ModelAttribute User user) {
        User createdUser = userService.saveUser(user);
        return createdUser;

        }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        User user = userOptional.get();
        return user;
    }


    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return "Deleting" + id.toString();
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable Long id) {
        return "Updated" + id.toString();
    }

    @PostMapping("/login")
    public User login(@RequestBody User login, HttpSession session) throws IOException {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = userRepo.findByUsername(login.getUsername());
        if(user ==  null){
            throw new IOException("Invalid Credentials");
        }
        boolean valid = bCryptPasswordEncoder.matches(login.getPassword(), user.getPassword());
        if(valid){
            session.setAttribute("username", user.getUsername());
            return user;
        }else{
            throw new IOException("Invalid Credentials");
        }
    }
}
