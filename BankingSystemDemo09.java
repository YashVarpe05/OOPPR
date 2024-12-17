import java.util.*;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class DailyWithdrawalLimitExceededException extends Exception {
    public DailyWithdrawalLimitExceededException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;

    private double dailyWithdrawalLimit;
    private double todayWithdrawnAmount;
    private Date lastWithdrawalDate;

    public BankAccount(String accountHolderName, String accountType) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = 0;
        this.dailyWithdrawalLimit = 5000; // Default daily limit
        this.todayWithdrawnAmount = 0;
        this.lastWithdrawalDate = new Date();
    }

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException, DailyWithdrawalLimitExceededException {
        Date today = new Date();
        if (today.getDate() != lastWithdrawalDate.getDate()) {
            todayWithdrawnAmount = 0;
            lastWithdrawalDate = today;
        }

        if (todayWithdrawnAmount + amount > dailyWithdrawalLimit) {
            throw new DailyWithdrawalLimitExceededException(
                    "Daily withdrawal limit of $" + dailyWithdrawalLimit + " exceeded");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Current balance: $" + balance);
        }

        balance -= amount;
        todayWithdrawnAmount += amount;
        System.out.println("Withdrawal successful. New balance: $" + balance);
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: $" + balance);
        System.out.println("Daily Withdrawal Limit: $" + dailyWithdrawalLimit);
    }
}

public class BankingSystemDemo09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Account Holder Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Account Type (Savings/Checking): ");
            String type = scanner.nextLine();

            BankAccount account = new BankAccount(name, type);

            while (true) {
                System.out.println("\n--- Banking System Menu ---");
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Check Balance");
                System.out.println("4. Display Account Information");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 2:
                        try {
                            System.out.print("Enter withdrawal amount: $");
                            double withdrawAmount = scanner.nextDouble();
                            account.withdraw(withdrawAmount);
                        } catch (InsufficientFundsException | DailyWithdrawalLimitExceededException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.println("Current Balance: $" + account.checkBalance());
                        break;

                    case 4:
                        account.displayAccountInfo();
                        break;

                    case 5:
                        System.out.println("Thank you for using our Banking System!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}