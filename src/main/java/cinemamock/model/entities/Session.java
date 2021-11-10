package cinemamock.model.entities;

import java.time.LocalDate;

public class Session {
    LocalDate date;
    String startTime;
    String finishTime;
    Double ticketPrice;
    String typeAnimation;
    String typeAudio;

    public Session(LocalDate date, String startTime, String finishTime, Double ticketPrice, String typeAnimation, String typeAudio) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
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
}