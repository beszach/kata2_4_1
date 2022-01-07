package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao{
    public void add(Role role);
    public List<Role> getAll();
    public Role getById(Long id);
}
