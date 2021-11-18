package cinemamock.controller;

import cinemamock.model.entities.Session;
import cinemamock.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping(value = "movies")
    List<Session> getSessions() {
        return sessionService.getSessions();
    }

    @PostMapping
    public void registerNewSession(@RequestBody Session session) {
        sessionService.addNewSession(session);
    }

    @DeleteMapping(path = "{movieId}")
    public void deleteSession(@PathVariable("movieId") Long sessionId) {
        sessionService.deleteSession(sessionId);
    }

    @PutMapping(path = "{movieId}")
    public void updateMovie(
            @PathVariable("movieId") Long movieId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) int duration,
            @RequestParam(required = false) String image) {
        sessionService.updateSession(movieId, title, description, duration, image);
    }
}

