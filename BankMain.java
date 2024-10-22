class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}

class Customer {
    private String name;
    private BankAccount bankAccount;

    public Customer(String name) {
        this.name = name;
        this.bankAccount = new BankAccount();
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    public boolean withdraw(double amount) {
        return bankAccount.withdraw(amount);
    }

    public double getBalance() {
        return bankAccount.getBalance();
    }

    public String getName() {
        return name;
    }
}

public class BankMain {
    public static void main(String[] args) {
        Customer customer = new Customer("Pak Haji");

        System.out.println("Nama Customer: " + customer.getName());
        System.out.println("Saldo: Rp. " + customer.getBalance());

        customer.deposit(100000);
        System.out.println("Deposit: Rp. 100000");
        System.out.println("Saldo: Rp. " + customer.getBalance());

        customer.withdraw(50000);
        System.out.println("Withdraw: Rp. 50000");
        System.out.println("Saldo: Rp. " + customer.getBalance());

        customer.withdraw(100000);
        System.out.println("Withdraw: Rp. 100000");
        System.out.println("Saldo: Rp. " + customer.getBalance());
    }
}