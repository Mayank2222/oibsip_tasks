import java.util.Scanner;

public class ATM {
    static double accountBalance = 1000.0; // Initial account balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userId = "12345";
        String userPin = "54321";

        // Welcome message
        System.out.println("Welcome to the ATM");

        // Prompt for user id and pin
        System.out.print("Enter User ID: ");
        String inputUserId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String inputPin = scanner.nextLine();

        // Check user credentials
        if (inputUserId.equals(userId) && inputPin.equals(userPin)) {
            System.out.println("Login successful. Welcome!");
            performTransactions();
        } else {
            System.out.println("Login failed. Please try again.");
        }

        scanner.close();
    }

    // Method to perform ATM transactions
    private static void performTransactions() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    Withdraw.performWithdrawal();
                    break;
                case 3:
                    Deposit.performDeposit();
                    break;
                case 4:
                    Transfer.performTransfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to check account balance
    private static void checkBalance() {
        System.out.println("Your account balance: $" + accountBalance);
    }
}

class Withdraw {
    public static void performWithdrawal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= ATM.accountBalance) {
            ATM.accountBalance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + ATM.accountBalance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }
}

class Deposit {
    public static void performDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            ATM.accountBalance += amount;
            System.out.println("Deposit successful. New balance: $" + ATM.accountBalance);
        } else {
            System.out.println("Invalid amount.");
        }
    }
}

class Transfer {
    public static void performTransfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the recipient's account number: ");
        String recipientAccount = scanner.next();
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();

        // Simulated recipient account
        String recipientAccountNumber = "54321";

        if (recipientAccount.equals(recipientAccountNumber) && amount > 0 && amount <= ATM.accountBalance) {
            ATM.accountBalance -= amount;
            System.out.println("Transfer successful. Remaining balance: $" + ATM.accountBalance);
        } else {
            System.out.println("Invalid recipient account or amount or insufficient funds.");
        }
    }
}
