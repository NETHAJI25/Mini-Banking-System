

class Account {
    private int accountNo;
    private String name;
    private double balance;
    private static final double MIN_BALANCE = 1000;

    // Constructor
    public Account(int accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    // Getter methods
    public int getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit Method (Method Overloading)
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully.");
    }

    public void deposit(double amount, String message) {
        balance += amount;
        System.out.println(message);
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawal Successful.");
        } else {
            System.out.println("Minimum balance condition violated!");
        }
    }

    // Convert object to string (for file storage)
    public String toString() {
        return accountNo + "," + name + "," + balance;
    }
}
