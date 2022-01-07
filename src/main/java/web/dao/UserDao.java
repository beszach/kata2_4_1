package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public void add(User model);
    public void update(User user);
    public void delete(Long id);
    public List<User> getAll();
    public User getById(Long id);
    public User findByEmail(String email);
}
