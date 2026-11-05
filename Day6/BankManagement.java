import java.util.Scanner;

class Account{
    private String accNo;
    private String name;
    private double balance;

    Account(String accNo,String name,double balance){
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        }else{
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount){
        if(amount>0 && balance>=amount){
            balance-=amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }else{
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    public double getBalance(){
        return balance;
    }

    public void displayDetails(){
        System.out.println("Account Number: "+accNo);
        System.out.println("Name: "+name);
        System.out.println("Balance: "+balance);
    }
}

class BankManagement{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Add an Account first..");
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();

        Account a1 = new Account(accNo,name,balance);

        System.out.println("\nAccount Created Successfully!");
        a1.displayDetails();

        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double amount1 = sc.nextDouble();
                    a1.deposit(amount1);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double amount2 = sc.nextDouble();
                    a1.withdraw(amount2);
                    break;
                case 3:
                    a1.displayDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}