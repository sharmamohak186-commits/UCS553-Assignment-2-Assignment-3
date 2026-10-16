import java.util.HashMap;
import java.util.Map;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) { super(message); }
}
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) { super(message); }
}
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) { super(message); }
}
class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public double getBalance() { return balance; }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Deposit must be positive.");
        balance += amount;
    }
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal must be positive.");
        if (amount > balance) throw new InsufficientBalanceException("Insufficient balance.");
        balance -= amount;
    }
}
public class BankingApp {
    static Map<String, BankAccount> accounts = new HashMap<>();
    static BankAccount findAccount(String number) throws AccountNotFoundException {
        BankAccount account = accounts.get(number);
        if (account == null) throw new AccountNotFoundException("Account not found: " + number);
        return account;
    }
    static void processDeposit(String number, double amount) throws AccountNotFoundException, InvalidAmountException {
        findAccount(number).deposit(amount);
    }
    static void processWithdrawal(String number, double amount)
            throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        findAccount(number).withdraw(amount);
    }

    public static void main(String[] args) {
        accounts.put("1001", new BankAccount("1001", 1000));
        try {
            processDeposit("1001", 500);
            processWithdrawal("1001", 300);
            System.out.println("Balance after successful transactions: Rs. " + findAccount("1001").getBalance());
            processWithdrawal("1001", 2000);
        } catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Transaction error: " + e.getMessage());
        }
        try {
            processDeposit("9999", 100);
        } catch (AccountNotFoundException | InvalidAmountException e) {
            System.out.println("Transaction error: " + e.getMessage());
        }
    }
}
