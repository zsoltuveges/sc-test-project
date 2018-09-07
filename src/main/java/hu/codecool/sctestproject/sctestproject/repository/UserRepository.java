package hu.codecool.sctestproject.sctestproject.repository;

import hu.codecool.sctestproject.sctestproject.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
