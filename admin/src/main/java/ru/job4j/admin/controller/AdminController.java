package ru.job4j.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.admin.service.AdminService;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService service;

    @GetMapping(value = {"/", "/index"})
    public String getIndex(Model model) {
        model.addAttribute("dishes", service.findAllDishes());
        return "index";
    }

}
