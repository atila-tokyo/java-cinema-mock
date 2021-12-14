package cinemamock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    public class LoginController {



        @GetMapping(value={"/", "/login"})
        public String login(Model model) {
            return login;
        }
    }
}