package com.practyka.practices.controller;

import com.practyka.practices.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final UserService userService;
    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("users",userService.list());
        return "admin";
    }
    @PostMapping("/admin/user/ban/{id}")
    public  String userBan(@PathVariable("id") Long id){
        userService.banUser(id);
        return "redirect:/admin";
    }


}
