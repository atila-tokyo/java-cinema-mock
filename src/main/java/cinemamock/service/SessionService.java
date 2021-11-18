package cinemamock.service;

import cinemamock.model.entities.Session;
import cinemamock.model.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getSessions() {
        return sessionRepository.findAll();
    }

    public Optional<Session> getSession(Session session) {
        return sessionRepository.findSessionByStartTime(session.getStartTime());
    }
    public void deleteSession(Long sessionId) {
    }

    public void updateSession(Long movieId, String title, String description, int duration, String image) {
    }

    public void addNewSession(Session session) {
    }

    public void updateSession(
                    Long movieId,
                    LocalDate date,
                    LocalTime startTime,
                    LocalTime finishTime,
                    double ticketPrice,
                    String typeAnimation,
                    String typeAudio
                ) {
    }
}