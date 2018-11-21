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

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        System.out.println("TEST MESSA GAY");
        User createdUser = userService.saveUser(user);
        System.out.println(createdUser);
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
    public User updateUser(@PathVariable Long id, @ModelAttribute User user) {
            Optional<User> userOptional = userRepo.findById(id);

            User user = userOptional.get();

            user.setText(userUsername.getText());
            User updatedPost = userRepo.save(user);
            return updatedPost;
    }

    @PostMapping("/login")
    public User login(@RequestBody User login, HttpSession session) throws IOException{
        System.out.println(login.getUsername());
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = userRepo.findByUsername(login.getUsername());
        if(user ==  null){
            System.out.println("no user");
            throw new IOException("Invalid Credentials");
        }
        boolean valid = bCryptPasswordEncoder.matches(login.getPassword(), user.getPassword());
        if(valid){
            session.setAttribute("username", user.getUsername());
            return user;
        }else{
            System.out.println("bad password");
            throw new IOException("Invalid Credentials");
        }
    }


}