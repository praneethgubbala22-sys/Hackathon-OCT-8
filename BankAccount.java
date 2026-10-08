import java.util.Scanner;

public class BankAccount {
   
    private final long  accountNumber;
    private String accountHolderName;
    private double balance;


    public BankAccount(long accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        System.out.println("======--- WELCOME TO THE BANK-ACCOUNT MANAGEMENT SYSTEM--- ======");
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }
        else {
            balance += amount;
            System.out.println("Deposit successful.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccount() {
        System.out.println("\n =========  Account details ========");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.printf("Balance: %.2f%n ", checkBalance());

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        long accountNumber = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter Account Holder Name: ");
        String accountHolderName = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accountNumber, accountHolderName, balance);
        account.displayAccount();

        System.out.print("Enter Deposit Amount: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);
        System.out.println("Enter Withdrawal Amount: ");
        double withdrawalAmount = sc.nextDouble();
        account.withdraw(withdrawalAmount);
        account.displayAccount();
    }
}