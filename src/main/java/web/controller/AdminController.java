package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String vievForAll(ModelMap modelMap){
        modelMap.addAttribute("users", userService.getAll());
        return "thymeleaf/admin_users";
    }

    @GetMapping("/add_user")
    public String addUser(ModelMap modelMap){
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("roles", roleService.getAll());
        return "thymeleaf/admin_add_user";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping("/userId{id}")
    public String userByID(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("user", userService.getById((long) id));
        return "thymeleaf/admin_user_by_id";
    }

    @GetMapping("/userId{id}/edit")
    public String editUser(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("user", userService.getById((long) id));
        modelMap.addAttribute("roles", roleService.getAll());
        return "thymeleaf/admin_edit_user";
    }

    @PostMapping("/userId{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("user") User updatedUser){
        userService.update(updatedUser);
        return "redirect:/admin";
    }

    @DeleteMapping("/userId{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete((long) id);
        return "redirect:/admin";
    }


}
