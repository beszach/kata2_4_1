package web.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.service.RoleService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class RoleFormatter implements Formatter<Role> {

    private final RoleService roleService;

    public RoleFormatter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Role parse(String text, Locale locale) throws ParseException {
        Long id = Long.parseLong(text);
        return roleService.getById(id);
    }

    @Override
    public String print(Role object, Locale locale) {
        return object.getId().toString();
    }
}
