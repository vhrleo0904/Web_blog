package kr.hs.dgsw.web_blog.Controller;

import kr.hs.dgsw.web_blog.Domain.User;
import kr.hs.dgsw.web_blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listuser")
    public List<User> listUser() {
        return userService.listUser();
    }

    @GetMapping("/getuser/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/adduser")
    public User addPost(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/removeuser/{userId}")
    public boolean removeUser(@PathVariable Long userId) {
        return userService.removeUser(userId);
    }

    @PutMapping("/modifyuser/{userId}")
    public User modifyUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.modifyUser(userId, user);
    }
}
