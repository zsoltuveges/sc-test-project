package hu.codecool.sctestproject.sctestproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private Long amount;

    @OneToMany
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

    public void deposit(Long amount) {
        this.amount += amount;
    }

    public void withdraw(Long amount) {
        this.amount -= amount;
    }
}
