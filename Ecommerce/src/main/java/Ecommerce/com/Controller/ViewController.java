package Ecommerce.com.Controller;

import Ecommerce.com.Entity.UserEntity;
import Ecommerce.com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/users-page")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add-user")
    public String showForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "add-user";
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute UserEntity user) {
        userService.createUser(user);
        return "redirect:/users-page";
    }

    @GetMapping("/edit-user/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute UserEntity user) {
        userService.updateUser(user.getId(), user);
        return "redirect:/users-page";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users-page";
    }
}