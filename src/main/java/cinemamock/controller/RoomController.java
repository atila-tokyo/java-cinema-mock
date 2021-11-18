package cinemamock.controller;

import cinemamock.model.entities.Room;
import cinemamock.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController (RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = "rooms")
    List<Room> getRooms() {
        return roomService.getRooms();
    }


}