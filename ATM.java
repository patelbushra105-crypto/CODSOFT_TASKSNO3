
import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    // Constructor
    BankAccount(double balance) {
        this.balance = balance;
    }

    // Check Account Balance
    public void checkBalance() {
        System.out.println("\nAvailable Balance: Rs. " + balance);
    }

    // Deposit Money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nRs. " + amount + " deposited successfully!");
        } else {
            System.out.println("\nInvalid deposit amount!");
        }
    }

    // Withdraw Money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("\nPlease enter a valid amount!");
        } else if (amount > balance) {
            System.out.println("\nTransaction Failed! Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("\nRs. " + amount + " withdrawn successfully!");
        }
    }
}

// ATM Class
public class ATM {

    private BankAccount account;
    private Scanner sc;

    // Constructor
    ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    // ATM Menu
    public void displayMenu() {
        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("          ATM MACHINE");
            System.out.println("================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: Rs. ");
                    if (sc.hasNextDouble()) {
                        account.deposit(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    if (sc.hasNextDouble()) {
                        account.withdraw(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                    break;

                case 4:
                    System.out.println("\nThank you for using our ATM!");
                    System.out.println("Please visit again.");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }

        } while (choice != 4);
    }

    // Main Method
    public static void main(String[] args) {

        // Create Bank Account
        BankAccount account = new BankAccount(10000);

        // Connect ATM with Bank Account
        ATM atm = new ATM(account);

        // Start ATM
        atm.displayMenu();
    }
}
