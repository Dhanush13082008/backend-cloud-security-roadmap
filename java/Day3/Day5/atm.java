package Day5;
import java.util.*;

class User {
    String accno;
    int pin;
    double balance;
    int withdrawalsRemaining;
    int failedAttemptsRemaining;
    boolean locked;

    User(String accno, int pin, double balance, int withdrawalsRemaining) {
        this.accno = accno.toUpperCase();
        this.pin = pin;
        this.balance = balance;
        this.withdrawalsRemaining = withdrawalsRemaining;
        this.failedAttemptsRemaining = 3;
        this.locked = false;
    }

    boolean checkCredentials(String accno, int pin) {
        return this.accno.equals(accno.toUpperCase()) && this.pin == pin;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful.");
    }

    void withdraw(double amount) {
        if (withdrawalsRemaining <= 0) {
            System.out.println("Daily withdrawal limit reached.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        withdrawalsRemaining--;

        System.out.println("Withdrawal successful.");
    }

    void balanceEnquiry() {
        System.out.println("Account number: " + accno);
        System.out.println("Balance: " + balance);
    }

    void changePin(int oldPin, int newPin) {
        if (pin == oldPin) {
            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect PIN.");
        }
    }
}

class ATM {

    ArrayList<User> users = new ArrayList<>();
    User currentUser = null;

    void addUser(User user) {
        users.add(user);
    }

    boolean login(String accno, int pin) {

        for (User user : users) {

            if (user.accno.equals(accno.toUpperCase())) {

                if (user.locked) {
                    System.out.println("Account is locked.");
                    return false;
                }

                if (user.checkCredentials(accno, pin)) {
                    currentUser = user;
                    user.failedAttemptsRemaining = 3;

                    System.out.println("Login successful.");
                    return true;
                }

                user.failedAttemptsRemaining--;

                System.out.println("Incorrect PIN.");
                System.out.println(
                    "Attempts remaining: " + user.failedAttemptsRemaining
                );

                if (user.failedAttemptsRemaining == 0) {
                    user.locked = true;
                    System.out.println("Account locked.");
                }

                return false;
            }
        }

        System.out.println("Account not found.");
        return false;
    }

    void logout() {
        currentUser = null;
        System.out.println("Logged out.");
    }

    void menu(Scanner in) {

        while (currentUser != null) {

            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Change PIN");
            System.out.println("5. Logout");

            int choice = in.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount: ");
                    double depositAmount = in.nextDouble();
                    currentUser.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double withdrawAmount = in.nextDouble();
                    currentUser.withdraw(withdrawAmount);
                    break;

                case 3:
                    currentUser.balanceEnquiry();
                    break;

                case 4:
                    System.out.print("Enter current PIN: ");
                    int oldPin = in.nextInt();

                    System.out.print("Enter new PIN: ");
                    int newPin = in.nextInt();

                    currentUser.changePin(oldPin, newPin);
                    break;

                case 5:
                    logout();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ATM atm = new ATM();

        atm.addUser(new User("25bce0248", 6699, 10000, 10));
        atm.addUser(new User("25bce0249", 1234, 20000, 10));
        atm.addUser(new User("25bce0250", 5678, 15000, 10));

        boolean running = true;

        while (running) {

            System.out.println("\n===== ATM =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");

            int choice = in.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter account number: ");
                    String accno = in.next();

                    System.out.print("Enter PIN: ");
                    int pin = in.nextInt();

                    if (atm.login(accno, pin)) {
                        atm.menu(in);
                    }

                    break;

                case 2:
                    running = false;
                    System.out.println("ATM closed.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        in.close();
    }
}
