public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample usage
        SavingsAccount savings = new SavingsAccount("SA001", "John Doe");
        savings.deposit(500);
        savings.withdraw(450);
        savings.showLastNTransactions(5);

        System.out.println();

        CurrentAccount current = new CurrentAccount("CA001", "Jane Smith");
        current.deposit(200);
        current.withdraw(600); // Overdraft
        current.showLastNTransactions(5);

        System.out.println();

        System.out.println("Enter maturity date for Fixed Deposit (YYYY-MM-DD): ");
        LocalDate maturity = LocalDate.parse(scanner.nextLine());
        FixedDepositAccount fixed = new FixedDepositAccount("FD001", "Emma Jones", maturity);
        fixed.deposit(1000);
        fixed.withdraw(500); // May fail if before maturity
        fixed.showLastNTransactions(5);
    }
}
