package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v3")
public class profile {

    @GetMapping("/acc")
    public String getAccount(){
        return "account";
    }

    @GetMapping("/grade")
    public String getGrades(){
        return "grade";
    }

    @GetMapping("/contact")
        public String getContact(){
        return "contact";
    }

}
