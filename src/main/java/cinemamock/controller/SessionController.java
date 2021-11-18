package cinemamock.controller;

import cinemamock.model.entities.Session;
import cinemamock.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping(value = "sessions")
    List<Session> getSessions() {
        return sessionService.getSessions();
    }

    @PostMapping(value = "new-session")
    public void registerNewSession(@RequestBody Session session) {
        sessionService.addNewSession(session);
    }

    @DeleteMapping(path = "{sessionId}")
    public void deleteSession(@PathVariable("sessionId") Long sessionId) {
        sessionService.deleteSession(sessionId);
    }

    @PutMapping(path = "{sessionId}")
    public void updateSession(
            @PathVariable("sessionId") Long movieId,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) LocalTime startTime,
            @RequestParam(required = false) LocalTime finishTime,
            @RequestParam(required = false) double ticketPrice,
            @RequestParam(required = false) String typeAnimation,
            @RequestParam(required = false) String typeAudio
            ) {
        sessionService.updateSession(
                            movieId,
                            date,
                            startTime,
                            finishTime,
                            ticketPrice,
                            typeAnimation,
                            typeAudio
                            );
    }
}

