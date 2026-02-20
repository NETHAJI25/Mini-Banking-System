import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- MINI BANKING SYSTEM ----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Search Account");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    Account acc = new Account(accNo, name, balance);
                    Bank.saveAccount(acc);
                    System.out.println("Account Created Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextInt();

                    Account depositAcc = Bank.searchAccount(accNo);
                    if (depositAcc != null) {
                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();
                        depositAcc.deposit(amt);
                        System.out.println("Updated Balance: " + depositAcc.getBalance());
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextInt();

                    Account withdrawAcc = Bank.searchAccount(accNo);
                    if (withdrawAcc != null) {
                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();
                        withdrawAcc.withdraw(amt);
                        System.out.println("Updated Balance: " + withdrawAcc.getBalance());
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextInt();

                    Account searchAcc = Bank.searchAccount(accNo);
                    if (searchAcc != null) {
                        System.out.println("Account Found:");
                        System.out.println("Name: " + searchAcc.getName());
                        System.out.println("Balance: " + searchAcc.getBalance());
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
