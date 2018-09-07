package hu.codecool.sctestproject.sctestproject.repository;

import hu.codecool.sctestproject.sctestproject.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
