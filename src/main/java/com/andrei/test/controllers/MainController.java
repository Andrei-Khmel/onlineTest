package com.andrei.test.controllers;

import com.andrei.test.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/password")
    public String showPassword(Model model) {
        Student studentObj = new Student();
        model.addAttribute("studentObj", studentObj);
        model.addAttribute("title", "password");
//        model.addAttribute("studentName", studentObj);
//        model.addAttribute("studentPassword", studentObj);
        return "password";
    }

    @PostMapping("/password")
        public String submitForm(@ModelAttribute("studentObj") Student studentObj){
        System.out.println(studentObj);
        return "pass";
    }

    // ФОРМА ВВОДА ПАРОЛЯ
    @RequestMapping(value = "/registerPassword", method = RequestMethod.POST)
    public String processPassword(@ModelAttribute("studentObj") Student studentObj){
//        model.addAttribute("pass", "pass");
        return "pass";
    }



    @GetMapping("/question")
    public String question(Model model) {
        model.addAttribute("title", "question");
        return "question";
    }

    @GetMapping("/pass")
    public String pass(Model model) {
        model.addAttribute("pass", "pass");
        return "pass";
    }

}