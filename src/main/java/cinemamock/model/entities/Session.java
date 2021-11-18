package cinemamock.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "session")
public class Session {

    @Id
    @SequenceGenerator(
            name = "session_sequence",
            sequenceName = "session_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "session_sequence"
    )

    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    private LocalDate date;

    @Column(name = "startTime", nullable = false, columnDefinition = "TIME")
    private LocalTime startTime;

    @Column(name = "finishTime", nullable = false, columnDefinition = "TIME")
    private LocalTime finishTime;

    @Column(name = "price", nullable = false, columnDefinition = "DOUBLE")
    private double ticketPrice;

    @Column(name = "typeAnimation", nullable = false, columnDefinition = "VARCHAR")
    private String typeAnimation;

    @Column(name = "typeAudio", nullable = false, columnDefinition = "VARCHAR")
    private String typeAudio;



    public Session(
                LocalDate date,
                LocalTime startTime,
                LocalTime finishTime,
                Double ticketPrice,
                String typeAnimation,
                String typeAudio
            ) {
        this.date = date;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.ticketPrice = ticketPrice;
        this.typeAnimation = typeAnimation;
        this.typeAudio = typeAudio;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalTime startTime) {
      this.startTime = startTime;
    }

    public void getFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTypeAnimation() {
        return typeAnimation;
    }

    public void setTypeAnimation(String typeAnimation) {
        this.typeAnimation = typeAnimation;
    }

    public String getTypeAudio() {
        return typeAudio;
    }

    public void setTypeAudio(String typeAudio) {
        this.typeAudio = typeAudio;
    }

    @Override
    public String toString() {
        return "Session{" +
                "Date: '" + date + '\'' +
                ", Start time: '" + startTime + '\'' +
                ", Finish time:" + finishTime +
                ", Ticket Price $" + ticketPrice  +
                ", Type of Animation: " + typeAnimation +
                ", Type of Audio: " + typeAudio +
                '}';
    }

}