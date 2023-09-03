import java.util.Random;

public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;
    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances
    // CONSTRUCTOR
    public BankAccount(){
        this.checkingBalance=0;
        this.savingsBalance=0;
        this.accountNumber=generateAccountNumber();
        accounts++;
    }
    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance=checkingBalance;
        this.savingsBalance=savingsBalance;
        this.accountNumber=generateAccountNumber();
        accounts++;
        totalMoney+=checkingBalance;
        totalMoney+=savingsBalance;
    }
    // GETTERS
    public double getCheckingBalance(){
        return checkingBalance;
    }
    public double getSavingsBalance(){
        return savingsBalance;
    }
    public static int getAccounts(){
        return accounts;
    }
    public static double getTotalMoney(){
        return totalMoney;
    }
    public String getAccountNumber(){
        return accountNumber;
    }

    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public double depositChecking(double amount){
        this.checkingBalance+=amount;
        totalMoney+=amount;
        return this.checkingBalance;
    }
    public double depositSavings(double amount){
        this.savingsBalance+=amount;
        totalMoney+=amount;
        return this.savingsBalance;
    }
    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds


    public String withdrawChecking(double amount){
        if(this.checkingBalance<amount){
            System.out.println("Insufficient funds");
            return "Insufficient funds";
        }
        else{
            totalMoney-=amount;
            this.checkingBalance-=amount;
            return String.valueOf(this.checkingBalance);
        }
    }
    public String withdrawSavings(double amount){
        if(this.savingsBalance<amount){
            return "Not sufficient funds";
        }
        else{
            totalMoney-=amount;
            this.savingsBalance-=amount;
            return String.valueOf(this.savingsBalance);
        }
    }
    private String generateAccountNumber(){
        Random randNum= new Random();
        String accountNumber;
        for(int i=0; i<10; i++){
            int nextNum=randNum.nextInt(10);
            accountNumber+=nextNum;
        }
        return accountNumber;
    }



    // - all deposits and withdrawals should affect totalMoney

    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public double getBalance(double checkingBalance, double savingsBalance){
        double balance= checkingBalance + savingsBalance;
        return balance;
    }
}
