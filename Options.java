package projectatmdt;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Options extends Account{

    Scanner scan = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    boolean flag = true;

    public void login(){
        do{
            data.put(12345,1234);
            data.put(23456,2345);
            data.put(34567,3456);
            data.put(45678,4567);

            System.out.println("Hi, Welcome to ATM...");

            try {
                System.out.print("Enter account number: ");
                setAccountNumber(scan.nextInt());
                System.out.print("Enter your pin number: ");
                setPinNumber(scan.nextInt());
            }catch(Exception e){
                System.out.println("You entered invalid characters, please enter an integer to proceed or press 'Q' to exit");
                scan.nextLine();
                String exit = scan.next().toLowerCase();
                if(exit.equals("q")){
                    flag = false;
                }
            }
            int count =0;
            for(Map.Entry<Integer,Integer> w : data.entrySet()){
                if(w.getKey().equals(getAccountNumber()) && w.getValue().equals(getPinNumber())){
                    getAccountTypes();
                }else{
                    count++;
                }
            }
            if(count==data.size()){
                System.out.println("Account number or pin number is not matching");
                System.out.println("Press any integer to try again or 'Q' to quit");
                String exit = scan.next().toLowerCase();
                if(exit.equals("q")){
                    flag = false;
                }
            }

        }while(flag==true);

    }

    public void getAccountTypes(){
        System.out.println("Select the account you want to access...");
        System.out.println("1: Checking Account");
        System.out.println("2: Saving Account");
        System.out.println("3: Quit");

        int selection = scan.nextInt();

        switch(selection){
            case 1:
                System.out.println("You are in checking account");
                checkingOperations();
                break;
            case 2:
                System.out.println("You are in saving account");
                savingOperations();
                break;
            case 3:
                System.out.println("Thanks for using ATM, see you later...");
                flag = false;
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2 or 3");
                getAccountTypes();
        }
    }

    public void checkingOperations(){
        do {
            System.out.println("Select option:");
            System.out.println("1:View Balance");
            System.out.println("2:Withdraw");
            System.out.println("3:Deposit");
            System.out.println("4:Exit");

            int option = scan.nextInt();
            if (option == 4) {
                break;
            }
            switch(option){
                case 1:
                    System.out.println("Your current checking balance: " + moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    getCheckingWithdraw();
                    break;
                case 3:
                    getCheckingDeposit();
                    break;
                default:
                    System.out.println("Invalid option, please select 1, 2, 3 or 4");
            }
        }while(true);
        getAccountTypes();
    }

    public void savingOperations(){
        do {
            System.out.println("Select option:");
            System.out.println("1:View Balance");
            System.out.println("2:Withdraw");
            System.out.println("3:Deposit");
            System.out.println("4:Exit");

            int option = scan.nextInt();
            if (option == 4) {
                break;
            }
            switch(option){
                case 1:
                    System.out.println("Your current saving balance: " + moneyFormat.format(getSavingBalance()));
                    break;
                case 2:
                    getSavingWithdraw();
                    break;
                case 3:
                    getSavingDeposit();
                    break;
                default:
                    System.out.println("Invalid option, please select 1, 2, 3 or 4");
            }
        }while(true);
        getAccountTypes();
    }

}