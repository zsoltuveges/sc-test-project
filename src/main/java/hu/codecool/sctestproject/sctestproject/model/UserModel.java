package hu.codecool.sctestproject.sctestproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private Long amount;

    @ElementCollection
    private List<Transaction> transactionHistory = new ArrayList<>();

    public UserModel(String username) {
        this.username = username;
    }

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void addTransactionToHistory(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void deposit(Long amount) {
        this.amount += amount;
    }

    public void withdraw(Long amount) {
        this.amount -= amount;
    }

    public List<Transaction> getDepositTransactionHistory() {
        return transactionHistory.stream().filter(amount -> amount.getAmount() > 0L).collect(Collectors.toList());
    }

    public List<Transaction> getTransactionHistoryByType(String type) {
        switch (type) {
            case "deposit":
                return transactionHistory.stream().filter(amount -> amount.getAmount() > 0L).collect(Collectors.toList());
            case "withdraw":
                return transactionHistory.stream().filter(amount -> amount.getAmount() < 0L).collect(Collectors.toList());
        }
        return null;
    }
}
