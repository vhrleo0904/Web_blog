package kr.hs.dgsw.web_blog.Service;

import kr.hs.dgsw.web_blog.Domain.User;
import kr.hs.dgsw.web_blog.Protocol.ResponseFormat;

import java.util.List;

public interface UserService {

    User login(String account, String password);

    User addUser(User user);

    boolean removeUser(Long userId);

    User modifyUser(Long userId, User user);

    List<User> listUser();

    User getUser(Long userId);
}
