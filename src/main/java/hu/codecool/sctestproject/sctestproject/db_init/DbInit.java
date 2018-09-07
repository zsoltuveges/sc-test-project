package hu.codecool.sctestproject.sctestproject.db_init;

import hu.codecool.sctestproject.sctestproject.model.UserModel;
import hu.codecool.sctestproject.sctestproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {

    @Autowired
    UserService userService;

    @PostConstruct
    public void init() {
        createUsers();
    }

    private void createUsers() {
        UserModel user1 = new UserModel("John");
        UserModel user2 = new UserModel("Alex");

        user1.setAmount(1234L);
        user2.setAmount(5678L);

        userService.save(user1);
        userService.save(user2);
    }
}
