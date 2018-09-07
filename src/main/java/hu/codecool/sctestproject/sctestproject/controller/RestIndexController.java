package hu.codecool.sctestproject.sctestproject.controller;

import hu.codecool.sctestproject.sctestproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestIndexController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index() {
        return "hello";
    }

    @PostMapping("/{userid}/deposit")
    public String deposit(@PathVariable("userid") Long userId, @RequestParam Long amount) {
        return "Success deposit";
    }

    @PostMapping("/{userid}/withdraw")
    public String withdraw(@PathVariable("userid") Long userId, @RequestParam Long amount) {
        return "Success withdraw";
    }
}
