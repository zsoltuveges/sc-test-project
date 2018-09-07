package hu.codecool.sctestproject.sctestproject.controller;

import hu.codecool.sctestproject.sctestproject.model.Transaction;
import hu.codecool.sctestproject.sctestproject.model.UserModel;
import hu.codecool.sctestproject.sctestproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionsController {

    @Autowired
    UserService userService;

    @GetMapping("/{userid}/transactions")
    public List<Transaction> getAllTransactionByUser(@PathVariable("userid") Long userId) {
        Optional<UserModel> userModel = userService.getUserById(userId);
        if (!userModel.isPresent()) {
            return null;
        }
        UserModel user = userModel.get();
        List<Transaction> transactionList = user.getTransactionHistory();
        return transactionList;
    }
}
