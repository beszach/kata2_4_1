package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService{
    public void add(Role role);
    public List<Role> getAll();
    public Role getById(Long id);
}
