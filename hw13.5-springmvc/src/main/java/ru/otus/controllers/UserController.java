package ru.otus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.otus.core.model.User;
import ru.otus.core.service.DBServiceUser;

import java.util.List;

@Controller
public class UserController {

    private final DBServiceUser serviceUser;

    public UserController(DBServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping({"/", "/user/list"})
    public String userListView(Model model) {
        List<User> users = serviceUser.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/user/create")
    public String userCreate(Model model) {
        model.addAttribute("user", new User());
        return "userCreate";
    }

    @PostMapping("/user/save")
    public RedirectView userSave(@ModelAttribute User user) {
        System.out.println(user);
        serviceUser.save(user);
        return new RedirectView("/", true);
    }

}
