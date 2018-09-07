package hu.codecool.sctestproject.sctestproject.controller;

import hu.codecool.sctestproject.sctestproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    UserService userService;

    @PostMapping("/transfer")
    public String transfer(
            @RequestParam Long transferFrom,
            @RequestParam Long transferTo,
            @RequestParam Long transferAmount) {
        boolean success = userService.transfer(transferFrom, transferTo, transferAmount);
        if (success) {
            return "Success transfer";
        }
        return "Transfer faild";
    }
}
