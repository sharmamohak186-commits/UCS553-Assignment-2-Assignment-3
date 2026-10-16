import java.util.Scanner;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) { super(message); }
}
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) { super(message); }
}
class AccountLockedException extends Exception {
    public AccountLockedException(String message) { super(message); }
}
class LoginService {
    private final String username = "student";
    private final String password = "java123";
    private int failedAttempts = 0;
    private final int maxAttempts = 3;
    private boolean locked = false;

    public void login(String enteredUser, String enteredPassword)
            throws InvalidUsernameException, InvalidPasswordException, AccountLockedException {
        if (locked) throw new AccountLockedException("Account is locked.");
        if (!username.equals(enteredUser)) {
            failedAttempts++;
            checkLock();
            throw new InvalidUsernameException("Invalid username.");
        }
        if (!password.equals(enteredPassword)) {
            failedAttempts++;
            checkLock();
            throw new InvalidPasswordException("Invalid password.");
        }
        failedAttempts = 0;
        System.out.println("Login successful. Welcome!");
    }
    private void checkLock() {
        if (failedAttempts >= maxAttempts) locked = true;
    }
}
public class LoginSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginService service = new LoginService();
        try {
            for (int attempt = 1; attempt <= 3; attempt++) {
                try {
                    System.out.print("Username: ");
                    String user = sc.nextLine();
                    System.out.print("Password: ");
                    String pass = sc.nextLine();
                    service.login(user, pass);
                    break;
                } catch (InvalidUsernameException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidPasswordException e) {
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println("Login attempt processed.");
                }
            }
            try {
                service.login("student", "java123");
            } catch (InvalidUsernameException | InvalidPasswordException | AccountLockedException e) {
                System.out.println(e.getMessage());
            }
        } catch (AccountLockedException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
