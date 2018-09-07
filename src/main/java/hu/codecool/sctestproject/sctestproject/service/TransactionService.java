package hu.codecool.sctestproject.sctestproject.service;

import hu.codecool.sctestproject.sctestproject.model.Transaction;
import hu.codecool.sctestproject.sctestproject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Long save(Transaction newTransaction) {
        transactionRepository.save(newTransaction);
        return newTransaction.getId();
    }
}
