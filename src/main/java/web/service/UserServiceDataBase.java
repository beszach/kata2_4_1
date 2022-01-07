package web.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service("userServiceDataBase")
@Transactional
@Slf4j
public class UserServiceDataBase implements UserService {

    private final UserDao userDao;

    public UserServiceDataBase(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
        log.info("Add user: {}", user);
    }


    @Override
    public void update(User user) {
        userDao.update(user);
        log.info("Update user: {}", user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
        log.info("Update delete user with id: {}", id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
