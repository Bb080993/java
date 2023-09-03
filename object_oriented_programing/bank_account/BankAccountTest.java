public class BankAccountTest{
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount account1= new BankAccount(500.50, 625.00);
        BankAccount account2= new BankAccount();
        BankAccount account3= new BankAccount(70.75, 639.23);
        
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        System.out.println(account1.getAccountNumber());
        //Number of Bank Accounts
        System.out.println(BankAccount.getAccounts());
        System.out.println(BankAccount.getTotalMoney());
        

        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        account1.depositChecking(0.50);
        account1.depositSavings(25.50);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        System.out.println(BankAccount.getTotalMoney());


        account2.depositChecking(50);
        account2.depositSavings(99.99);
        System.out.println(account2.getAccountNumber());
        // System.out.println(account2.getCheckingBalance());
        // System.out.println(account2.getSavingsBalance());

        account3.depositChecking(1);
        account3.depositSavings(22.23);
        // System.out.println(account3.getCheckingBalance());
        // System.out.println(account3.getSavingsBalance());

        System.out.println(BankAccount.getTotalMoney());
        // - each deposit should increase the amount of totalMoney
        // Withdrawal Test
        account1.withdrawChecking(100);
        account1.withdrawSavings(200);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        System.out.println(BankAccount.getTotalMoney());

        account2.withdrawChecking(200);
        account2.withdrawSavings(200);
        System.out.println(account2.getCheckingBalance());
        System.out.println(account2.getSavingsBalance());
        System.out.println(BankAccount.getTotalMoney());

        account3.withdrawChecking(300);
        account3.withdrawSavings(200);
        System.out.println(account3.getCheckingBalance());
        System.out.println(account3.getSavingsBalance());
        //Total Money
        System.out.println(BankAccount.getTotalMoney());

        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        // Static Test (print the number of bank accounts and the totalMoney)
    }
}