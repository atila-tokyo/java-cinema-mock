package cinemamock.controller;

import cinemamock.model.entities.Room;
import cinemamock.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;


    @GetMapping(value = "room")
    public String getRooms(Model model) {
        List<Room> rooms = roomService.getRooms();
        model.addAttribute("rooms", rooms);
        return "room";
    }

    @GetMapping(value = "room/create")
    public String create(Model model) {
        return "create_room";
    }

    @GetMapping(value = "room/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Room> room = roomService.findById(id);
        model.addAttribute("room", room.get());
        return "edit_room";
    }

    @GetMapping(value = "room/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        Boolean isDelete = roomService.delete(id);
        if (isDelete) {
            model.addAttribute("message", "Room successfully deleted");
        } else {
            model.addAttribute("message", "Room not deleted");
        }
        List<Room> rooms = roomService.getRooms();
        return "room";
    }

    @PostMapping(value = "room")
    public String save(Room room, Model model) {
        if(room != null) {
            roomService.save(room);
        }
        model.addAttribute("message", "Room successfully added");
        List<Room> rooms = roomService.getRooms();
        model.addAttribute("rooms", rooms);
        return "room";
    }

    @PostMapping(value = "room/edit")
    public String update(Room room, Model model) {
        if (room != null) {
            roomService.save(room);
        }
        model.addAttribute("message", "Room successfully updated");
        List<Room> rooms = roomService.getRooms();
        model.addAttribute("rooms", rooms);
        return "room";
    }
}