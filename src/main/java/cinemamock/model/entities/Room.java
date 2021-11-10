package cinemamock.model.entities;

public class Room {
    String name;
    Integer seats;

    public Room(String name, Integer seats) {
        this.name = name;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", seats=" + seats +
                '}';
    }
}