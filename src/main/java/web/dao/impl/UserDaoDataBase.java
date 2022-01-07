package web.dao.impl;

import org.springframework.stereotype.Repository;
import web.dao.UserDao;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository("userRep")
public class UserDaoDataBase implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }


    @Override
    public void update(User userUpdated) {
        entityManager.merge(userUpdated);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findByEmail(String email) {
        Query query = entityManager.createQuery("from User where email =:email");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }
}
