package cinemamock.service;

import cinemamock.model.entities.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> getRooms();

    Optional<Room> getRoom(Room room);

    void save(Room room);

    Optional<Room> findById(Long id);

    Boolean delete(Long id);



}