import java.time.LocalDate;
import java.util.Scanner;

abstract class Account {
    // Initialize the current balance, acount number and user name of the account
    double current_balance = 0;
    String account_number;
    String user_name;
    String type;


    // Method for making deposits
    void deposit(double amount) {
        this.current_balance += amount;
        System.out.printf("Deposit successful, your balance is now: %f", this.current_balance);
        System.out.println();
    }

    // Method for making withdrawals
    void withdraw(double amount) {
        // Validate that the operation is possible.
        if (this.current_balance == 0) {
            System.out.println("You are broke, what? you want me to pull money from my sinks?");
            return;
        }
        if (this.current_balance <= amount) {
            System.out.printf("You do have enough funds to withdraw %f", amount);
            System.out.println("Get Money Bro.");
            return;
        }

        this.current_balance -= amount;
        System.out.printf("Withdrawal Successful, you now have %f (i.e: You almost broke.)", this.current_balance);
    };
}

class savings extends Account {
    String type = "Savings";
}

class current extends Account {
    String type = "Current";
}

class fixedDep extends Account {
    String type = "Fixed Deposit";

    Scanner scanner = new Scanner(System.in);

    void deposit(double amount) {
        System.out.println("Enter withdrawal date (YYYY-MM-DD) >:");
        String input = scanner.nextLine();
        LocalDate futureDate = LocalDate.parse(input);
    }

}

public class BAMS {
    public static void main(String[] args) {

         savings new_account = new savings();
        System.out.println(new_account.current_balance);;
    }
}
