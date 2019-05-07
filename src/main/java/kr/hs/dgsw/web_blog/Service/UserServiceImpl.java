package kr.hs.dgsw.web_blog.Service;

import kr.hs.dgsw.web_blog.Domain.User;
import kr.hs.dgsw.web_blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String account, String password) {
        return userRepository.findByAccount(account)
                .map(u -> {
                    if (u.comparePassword(password))
                        return u;
                    return null;
                })
                .orElse(null);
    }

    @Override
    public User addUser(User user) {
        if (userRepository.findByAccount(user.getAccount()).isPresent())
            return null;
        return userRepository.save(user);
    }

    @Override
    public boolean removeUser(Long userId) {
        try {
            userRepository.deleteById(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User modifyUser(Long userId, User user) {
        return userRepository.findById(userId)
                .map(u -> {

                    u.setProfilePath(user.getProfilePath() != null ? user.getProfilePath() : u.getProfilePath());
                    u.setEmail(user.getEmail() != null ? user.getEmail() : u.getEmail());
                    u.setName(user.getName() != null ? user.getName() : u.getName());
                    u.setPhone(user.getPhone() != null ? user.getPhone() : u.getPhone());
                    return userRepository.save(u);
                })
                .orElse(null);
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElse(null);
    }
}
