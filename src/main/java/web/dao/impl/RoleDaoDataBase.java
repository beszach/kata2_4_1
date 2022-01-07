package web.dao.impl;


import org.springframework.stereotype.Repository;
import web.dao.RoleDao;
import web.model.Role;
import javax.persistence.*;
import java.util.List;

@Repository("roleRep")
public class RoleDaoDataBase implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public RoleDaoDataBase() {
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }


    @Override
    public List<Role> getAll() {
        TypedQuery<Role> query = entityManager.createQuery("from Role", Role.class);
        return query.getResultList();
    }

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class, id);
    }




}
