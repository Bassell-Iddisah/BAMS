package com.example.tryfx;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

// Define interface for mandatory operations
interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    void showLastNTransactions(int n);
}

// Create abstract class for Account
abstract class Account implements BankOperations {
    double currentBalance;
    String accountNumber;
    String userName;
    String type;
    LinkedList<String> transactionHistory = new LinkedList<>();

    public Account(String accountNumber, String userName) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.currentBalance = 0;
    }

    public void deposit(double amount) {
        currentBalance += amount;
        transactionHistory.add("Deposited: " + amount);
        System.out.printf("Deposit successful. New balance: %.2f%n", currentBalance);
    }

    public void withdraw(double amount) {
        if (currentBalance == 0 || currentBalance < amount) {
            System.out.println("Insufficient funds.");
            return;
        }
        currentBalance -= amount;
        transactionHistory.add("Withdrew: " + amount);
        System.out.printf("Withdrawal successful. New balance: %.2f%n", currentBalance);
    }

    public double getBalance() {
        return currentBalance;
    }

    public void showLastNTransactions(int n) {
        int start = Math.max(0, transactionHistory.size() - n);
        for (int i = start; i < transactionHistory.size(); i++) {
            System.out.println(transactionHistory.get(i));
        }
    }
}

// Create SavingsAccount to inherit Account
class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 100.0;

    public SavingsAccount(String accountNumber, String userName) {
        super(accountNumber, userName);
        this.type = "Savings";
    }

    @Override
    public void withdraw(double amount) {
        if (currentBalance - amount < MIN_BALANCE) {
            System.out.println("Cannot withdraw. Minimum balance must be maintained.");
            return;
        }
        super.withdraw(amount);
    }
}

// Create CurrentAccount to inherit Account
class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 500.0;

    public CurrentAccount(String accountNumber, String userName) {
        super(accountNumber, userName);
        this.type = "Current";
    }

    @Override
    public void withdraw(double amount) {
        if (currentBalance - amount < -OVERDRAFT_LIMIT) {
            System.out.println("Overdraft limit exceeded.");
            return;
        }
        super.withdraw(amount);
    }
}

// Create FixedDepositAccount to inherit Account
class FixedDepositAccount extends Account {
    private LocalDate maturityDate;

    public FixedDepositAccount(String accountNumber, String userName, LocalDate maturityDate) {
        super(accountNumber, userName);
        this.type = "Fixed Deposit";
        this.maturityDate = maturityDate;
    }

    @Override
    public void withdraw(double amount) {
        if (LocalDate.now().isBefore(maturityDate)) {
            System.out.println("Cannot withdraw before maturity date: " + maturityDate);
            return;
        }
        super.withdraw(amount);
    }

    // Overide the deposit method of parent class
    @Override
    public void deposit(double amount) {
        if (currentBalance > 0) {
            System.out.println("Additional deposits not allowed for Fixed Deposit Account.");
            return;
        }
        super.deposit(amount);
    }
}

public class BAMS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Job Done");
    }
}

