package kr.hs.dgsw.web_blog.Controller;

import kr.hs.dgsw.web_blog.Domain.User;
import kr.hs.dgsw.web_blog.Protocol.ResponseFormat;
import kr.hs.dgsw.web_blog.Protocol.ResponseType;
import kr.hs.dgsw.web_blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listuser")
    public ResponseFormat listUser() {
        ResponseFormat rf = new ResponseFormat(ResponseType.FAIL, null);
        List<User> userList = userService.listUser();
        if (userList != null) {
            rf = new ResponseFormat(
                    ResponseType.USER_LIST,
                    userList,
                    (long) userList.size()
            );
        }
        return rf;
    }

    @GetMapping("/getuser/{userId}")
    public ResponseFormat getUser(@PathVariable Long userId) {
        ResponseFormat rf = new ResponseFormat(ResponseType.FAIL, null);
        User user = userService.getUser(userId);
        if (user != null) {
            rf = new ResponseFormat(
                    ResponseType.USER_GET,
                    user,
                    user.getId()
            );
        }
        return rf;
    }

    @PostMapping("/adduser")
    public ResponseFormat addPost(@RequestBody User user) {
        ResponseFormat rf = new ResponseFormat(ResponseType.FAIL, null);
        User u = userService.addUser(user);
        if (u != null) {
            rf = new ResponseFormat(
                    ResponseType.USER_ADD,
                    u,
                    u.getId()
            );
        }
        return rf;
    }

    @DeleteMapping("/removeuser/{userId}")
    public ResponseFormat removeUser(@PathVariable Long userId) {
        ResponseFormat rf = new ResponseFormat(ResponseType.FAIL, null);
        if (userService.removeUser(userId)) {
            rf = new ResponseFormat(
                    ResponseType.USER_DELETE,
                    true,
                    userId
            );
        }
        return rf;
    }

    @PutMapping("/modifyuser/{userId}")
    public ResponseFormat modifyUser(@PathVariable Long userId, @RequestBody User user) {
        ResponseFormat rf = new ResponseFormat(ResponseType.FAIL, null);
        User u = userService.modifyUser(userId, user);
        if (u != null) {
            rf = new ResponseFormat(
                    ResponseType.USER_UPDATE,
                    u,
                    u.getId()
            );
        }
        return rf;
    }
}
