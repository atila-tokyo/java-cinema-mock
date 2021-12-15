package cinemamock.controller;

import cinemamock.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController (RoomService roomService) {
        this.roomService = roomService;
    }

//    @GetMapping(value = "rooms")
//    List<Room> getRooms() {
//        return roomService.getRooms();
//    }
}