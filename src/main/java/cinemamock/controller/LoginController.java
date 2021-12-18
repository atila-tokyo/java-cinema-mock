package cinemamock.controller;


import cinemamock.model.entities.User;
import cinemamock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value={"/", "/login"})
    public String login(Model model) {
        return "login";
        }

    @GetMapping(value={"/home"})
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail((auth.getName()));
        model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
        return "home";
    }

}
