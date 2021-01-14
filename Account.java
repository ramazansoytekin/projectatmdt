package projectatmdt;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner scan = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public int getPinNumber() {
        return pinNumber;
    }
    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
    public double getCheckingBalance() {
        return checkingBalance;
    }
    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }
    public double getSavingBalance() {
        return savingBalance;
    }
    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }
    //Calculate checking balance after withdraw
    private double calcCheckingBalanceAfterWithdraw(double amount){
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }
    //Calculate checking balance after deposit
    private double calcCheckingBalanceAfterDeposit(double amount){
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }
    //Calculate saving balance after withdraw
    private double calcSavingBalanceAfterWithdraw(double amount){
        savingBalance = savingBalance - amount;
        return savingBalance;
    }
    //Calculate saving balance after deposit
    private double calcSavingBalanceAfterDeposit(double amount){
        savingBalance = savingBalance + amount;
        return savingBalance;
    }
    //Interact with customer to withdraw from checking account
    public void getCheckingWithdraw(){
        System.out.println("Your checking balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to withdraw: ");
        double amount = scan.nextDouble();
        if (amount<=0) {
			System.out.println("Negative or zero amount is not acceptable");
			getCheckingWithdraw();
		}else if(checkingBalance>=amount){
            calcCheckingBalanceAfterWithdraw(amount);
            System.out.println("Your checking balance: " + moneyFormat.format(checkingBalance));
        }else{
            System.out.println("Not enough money in your account to withdraw...");
        }
    }
    //Interact with customer to deposit to checking account
    public void getCheckingDeposit(){
        System.out.println("Your checking balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to deposit: ");
        double amount = scan.nextDouble();

        if (amount<=0) {
			System.out.println("Negative or zero amount is not acceptable");
			getCheckingDeposit();
		}else {
			calcCheckingBalanceAfterDeposit(amount);
	        System.out.println("Your checking balance: " + moneyFormat.format(checkingBalance));
		}
    }
    //Interact with customer to withdraw from saving account
    public void getSavingWithdraw() {
        System.out.println("Your saving balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw: ");
        double amount = scan.nextDouble();

        if (amount<=0) {
			System.out.println("Negative or zero amount is not acceptable");
			getSavingWithdraw();
		}else if (savingBalance >= amount) {
            calcSavingBalanceAfterWithdraw(amount);
            System.out.println("Your saving balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Not enough money in your account to withdraw...");
        }
    }
    //Interact with customer to deposit to saving account
    public void getSavingDeposit(){
        System.out.println("Your saving balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to deposit: ");
        double amount = scan.nextDouble();

        if (amount<=0) {
			System.out.println("Negative or zero amount is not acceptable");
			getSavingDeposit();
		}else {
	        calcSavingBalanceAfterDeposit(amount);
	        System.out.println("Your saving balance: " + moneyFormat.format(savingBalance));
		}
    }

}