package com.example.demo.Controller;

import javax.servlet.http.HttpSession;

import com.example.demo.Entity.UserDtls;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDtls user, HttpSession session) {

        // System.out.println(user);

        boolean f = userService.checkEmail(user.getEmail());

        if (f) {
            session.setAttribute("msg", "Email Id alreday exists");
        }

        else {
            UserDtls userDtls = userService.createUser(user);
            if (userDtls != null) {
                session.setAttribute("msg", "Register Sucessfully");
            } else {
                session.setAttribute("msg", "Something wrong on server");
            }
        }

        return "redirect:/register";
    }

    @GetMapping("/loadforgotPassword")
    public String loadForgetPassword(){
        return "lost_password";
    }
    @GetMapping("/loadresetPassword/{id}")
    public String resetPassword(@PathVariable int id, Model m){
        m.addAttribute("id",id);
        return "reset_password";
    }
    @PostMapping("/forgotPassword")
    public String forgotPassword(@RequestParam String email, @RequestParam String mobileNum , HttpSession session){
        UserDtls user=userRepo.findByEmailAndMobilenum(email,mobileNum);
        if(user!=null){
            return "redirect:/loadresetPassword/"+ user.getId();
        }
        else{
            session.setAttribute("msg","invalid emails & mobile number");
            return "lost_password";
        }


    }
    @PostMapping("/changePassword")
    public String resetpassword(@RequestParam String psw,@RequestParam Integer id,HttpSession session){
        UserDtls user =userRepo.findById(id).get();
        String encryptPsw=passwordEncoder.encode(psw);
        user.setPassword(encryptPsw);
        UserDtls updateuser=userRepo.save(user);
        if(updateuser!=null){
            session.setAttribute("msg","password change sucessfully");
        }
        return "redirect:/loadforgotPassword";
    }

}