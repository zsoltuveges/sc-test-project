package hu.codecool.sctestproject.sctestproject.service;

import hu.codecool.sctestproject.sctestproject.model.UserModel;
import hu.codecool.sctestproject.sctestproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Long save(UserModel newUser) {
        userRepository.save(newUser);
        return newUser.getId();
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void depositAmount(UserModel user, Long amount) {
        user.deposit(amount);
        userRepository.save(user);
    }

    public void withdrawAmount(UserModel user, Long amount) {
        user.withdraw(amount);
        userRepository.save(user);
    }
}
