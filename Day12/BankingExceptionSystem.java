class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String message){
        super(message);
    }
}
class AccountNotFoundException extends Exception{
    AccountNotFoundException(String message){
        super(message);
    }
}
class InvalidAmountException extends Exception{
    InvalidAmountException(String message){
        super(message);
    }
}

class Account{
    private int accountNum;
    private String accountHolderName;
    private double balance;

    public Account(int accountNum, String accountHolderName, double balance){
        this.accountNum = accountNum;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNum(){
        return accountNum;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException{
        if(amount <= 0){
            throw new InvalidAmountException("Amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException{
        if(amount <= 0){
            throw new InvalidAmountException("Amount must be positive");
        }
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }
}

class Bank{
    private Account[] accounts;
    private int count;

    public Bank(int size){
        accounts = new Account[size];
        count = 0;
    }

    public void addAccount(Account account){
        if(count < accounts.length){
            accounts[count] = account;
            count++;
        }else{
            System.out.println("Bank is full");
        }
    }

    public Account findAccount(int accountNum) throws AccountNotFoundException{
        for(int i = 0; i < count; i++){
            if(accounts[i].getAccountNum() == accountNum){
                return accounts[i];
            }
        }
        throw new AccountNotFoundException("Account not found: " + accountNum);
    }
}

public class BankingExceptionSystem{
    public static void main(String[] args){
        Bank bank = new Bank(10);
        Account account1 = new Account(101, "John", 50000);
        Account account2 = new Account(102, "Jane", 60000);
        Account account3 = new Account(103, "Bob", 70000);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

        try {
            Account acc = bank.findAccount(101);
            acc.deposit(2000);
            System.out.println("Balance: " + acc.getBalance());

        } catch (AccountNotFoundException |
                 InvalidAmountException e) {

            System.out.println(e.getMessage());
        }

        try {
            Account acc = bank.findAccount(102);
            acc.withdraw(80000);

        } catch (AccountNotFoundException |
                 InvalidAmountException |
                 InsufficientBalanceException e) {

            System.out.println(e.getMessage());
        }

        try {
            Account acc = bank.findAccount(103);
            acc.deposit(-500);

        } catch (AccountNotFoundException |
                 InvalidAmountException e) {

            System.out.println(e.getMessage());
        }

        try {
            Account acc = bank.findAccount(999);
            acc.getBalance();

        } catch (AccountNotFoundException e) {

            System.out.println(e.getMessage());
        } 
    }
}   