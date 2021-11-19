package cinemamock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "Login");
        return "login";
    }

    @RequestMapping("/movie")
    public String movie(Map<String, Object> model) {
        model.put("message", "You are in movies page");
        return "movieMgmt";
    }

    @RequestMapping("/room")
    public String rooms(Map<String, Object> model) {
        model.put("message", "You are in rooms page");
        return "rooms";
    }

}
