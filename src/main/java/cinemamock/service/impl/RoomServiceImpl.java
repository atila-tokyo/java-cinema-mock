package cinemamock.service.impl;

import cinemamock.model.entities.Room;
import cinemamock.model.repository.RoomRepository;
import cinemamock.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;


    public List<Room> getRooms() {

        return roomRepository.findAll();
    }

    public Optional<Room> getRoom(Room room) {

        return roomRepository.findRoomByName(room.getName());
    }

     public void save(Room room) {

        roomRepository.save(room);
    }

    public Optional<Room> findById(Long id) {

        return roomRepository.findById(id);
    }

    public Boolean delete(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if(room.isPresent()) {
            roomRepository.delete(room.get());
            return true;
        }
        return false;
    }
}
