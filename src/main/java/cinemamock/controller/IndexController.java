package cinemamock.controller;

import cinemamock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        model.put("message", "Login");
        return "login";
    }

    @RequestMapping(value = "/moviemgmt", method = RequestMethod.GET)
    public String movie(Map<String, Object> model) {
        model.put("message", "You are in movies page");
        return "movieMgmt";
    }

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public String rooms(Map<String, Object> model) {
        model.put("message", "You are in rooms page");
        return "rooms";
    }

}
