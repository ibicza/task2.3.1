package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "userList";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        userDao.saveUser(user);
        List<User> users = userDao.getAllUsers();
        model.addAttribute("users", users);
        return "redirect:/";
    }



    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        User user = userDao.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userDao.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userDao.deleteUser(id);
        return "redirect:/";
    }
}
