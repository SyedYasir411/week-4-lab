import java.util.*;

class Customer {
    String accountNumber;
    double balance;

    public Customer(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountNumber: " + accountNumber + " | Balance: $" + balance;
    }
}

public class Banking_System {
    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();
    public void addCustomer(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedByBalance.putIfAbsent(balance, new ArrayList<>());
        sortedByBalance.get(balance).add(accountNumber);
    }

    public void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.add(accountNumber);
        System.out.println("Withdrawal request for $" + amount + " from Account: " + accountNumber);
        processWithdrawals(amount);
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                // Withdraw the amount
                accounts.put(accountNumber, currentBalance - amount);
                System.out.println("Processed withdrawal for Account: " + accountNumber + " | New Balance: $" + accounts.get(accountNumber));
            } else {
                System.out.println("Insufficient funds for Account: " + accountNumber + " | Balance: $" + currentBalance);
            }
        }
    }

    public void showSortedByBalance() {
        System.out.println("\nCustomers sorted by balance:");
        for (Map.Entry<Double, List<String>> entry : sortedByBalance.entrySet()) {
            for (String accountNumber : entry.getValue()) {
                System.out.println("AccountNumber: " + accountNumber + " | Balance: $" + entry.getKey());
            }
        }
    }

    public void showAllAccounts() {
        System.out.println("\nAll customer accounts:");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println(entry.getKey() + " | Balance: $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Banking_System bank = new Banking_System();

        bank.addCustomer("A1001", 500.0);
        bank.addCustomer("A1002", 300.0);
        bank.addCustomer("A1003", 1000.0);
        bank.addCustomer("A1004", 700.0);

        bank.showAllAccounts();
        bank.showSortedByBalance();

        bank.requestWithdrawal("A1002", 200);
        bank.requestWithdrawal("A1001", 600);
        bank.requestWithdrawal("A1003", 500);
    }
}
