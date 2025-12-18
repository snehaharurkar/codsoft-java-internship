package ATM;

import java.util.Scanner;

public class ATM {

    private Bankaccount account;
    private Scanner sc;

    public ATM(Bankaccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    public static void main(String[] args) {
        Bankaccount userAccount = new Bankaccount(5000); // initial balance
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
