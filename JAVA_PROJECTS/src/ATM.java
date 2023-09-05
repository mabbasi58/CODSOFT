public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        userAccount = account;
    }

    public void withdraw(double amount) {
        if (amount > 0 && userAccount.getBalance() >= amount) {
            userAccount.decreaseBalance(amount);
            System.out.println("Withdrawal successful. New balance: " + userAccount.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            userAccount.increaseBalance(amount);
            System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
        } else {
            System.out.println("Deposit failed. Invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }
}
