import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }

    // Balance Check
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

// ATM Class
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        account.checkBalance();
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ₹");
                        double deposit = scanner.nextDouble();
                        account.deposit(deposit);
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdraw = scanner.nextDouble();
                        account.withdraw(withdraw);
                        break;

                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.nextLine(); // Clear the invalid input
                choice = 0; // Reset choice to continue the loop
            }

        } while (choice != 4);

        scanner.close();
    }
}

// Main Class
public class AtmInterface {

    public static void main(String[] args) {

        // Initial Balance
        BankAccount account = new BankAccount(10000);

        ATM atm = new ATM(account);

        atm.start();
    }
}