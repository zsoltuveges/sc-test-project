package hu.codecool.sctestproject.sctestproject.service;

import hu.codecool.sctestproject.sctestproject.model.Transaction;
import hu.codecool.sctestproject.sctestproject.model.UserModel;
import hu.codecool.sctestproject.sctestproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionService transactionService;

    public Long save(UserModel newUser) {
        userRepository.save(newUser);
        return newUser.getId();
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void depositAmount(UserModel user, Long amount) {
        user.deposit(amount);
        Transaction transaction = new Transaction(LocalDateTime.now(), amount, user.getAmount());
        transactionService.save(transaction);
        user.addTransactionToHistory(transaction);
        userRepository.save(user);
    }

    public void withdrawAmount(UserModel user, Long amount) {
        user.withdraw(amount);
        userRepository.save(user);
    }

    public boolean transfer(Long transferFrom, Long transferTo, Long transferAmount) {
        Optional<UserModel> userFrom = getUserById(transferFrom);
        Optional<UserModel> userTo = getUserById(transferTo);
        if (!userFrom.isPresent()) {
            return false;
        }
        if (!userTo.isPresent()) {
            return false;
        }
        UserModel userModelFrom = userFrom.get();
        UserModel userModelTo = userTo.get();
        userModelFrom.withdraw(transferAmount);
        userModelTo.deposit(transferAmount);

        userRepository.save(userModelFrom);
        userRepository.save(userModelTo);

        return true;
    }
}
