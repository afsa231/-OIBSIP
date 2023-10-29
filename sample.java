import java.util.Scanner;

class Bankaccount{
    String name;
    String user;
    String pwd;
    String accno;
    float blnce=100000f;
    int trans=0;
    String history="";

    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name here: ");
        this.name=sc.nextLine();
        System.out.println("enter user name here:");
        this.user=sc.nextLine();
        System.out.println("enter your password :");
        this.pwd=sc.nextLine();
        System.out.println("Enter account number here: ");
        this.accno=sc.nextLine();
        System.out.println("Your Registration is successfull...");
    }
   public boolean login() {
    boolean isLogin = false;
    Scanner sc = new Scanner(System.in);
    while (!isLogin) {
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        if (username.equals(user)) {
            while (!isLogin) {
                System.out.println("Enter your password: ");
                String password = sc.nextLine();
                if (password.equals(pwd)) {
                    System.out.println("You have logged in");
                    isLogin = true;
                } else {
                    System.out.println("Incorrect password");
                    break; 
                }
            }
        } else {
            System.out.println("Username not found");
            break; 
        }
    }
    return isLogin;
}
    public void withdraw(){
        System.out.println("Enter amount to withdraw :");
        Scanner sc=new Scanner(System.in);
        float amt=sc.nextFloat();
        try{
            if(blnce>=amt){
                trans++;
                blnce-=amt;
                System.out.println("succesfull");
                String str=amt+" withdrawn\n";
                history=history.concat(str);
            }
            else{
                System.out.println("Insufficient balance");
            }
        }
        catch(Exception e){

        }
    }
    public void deposit(){
        System.out.println("Enter amount to deposit");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();

        try{
            if(amount<=100000f){
                trans++;
                blnce+=amount;
                System.out.println("Suucessfully deposited");
                String str=amount+" deposited\n";
                history=history.concat(str);
            }
            else{
                System.out.println("sorry this is huge");
            }
        }
        catch(Exception e){
        }
    }
    public void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter person name :");
        String receipent=sc.nextLine();
        System.out.println("enter amount to be transfered :");
        float amount=sc.nextFloat();

        try{
            if(blnce>=amount){
                if(amount<=50000f){
                    trans++;
                    blnce-=amount;
                    System.out.println("succesfully transfered to "+receipent);
                    String str= amount+"rs transferred to "+receipent+"\n";
                    history=history.concat(str);
                }
                else{
                    System.out.println("sorry overlimit");
                }
            }
            else{
                System.out.println("Insufficient balance");
            }
        }
        catch(Exception e){

        }
    }
    public void checkbalance(){
        System.out.println("\n"+blnce+" rs");
    }
    public void transHistory(){
        if(trans==0){
            System.out.println("Empty");
        }
        else{
            System.out.println("\n"+history);
        }
    }
}
public class sample{
    public static int takeIntegerInput(int limit){
        int ipt=0;
        boolean flag=false;

        while(!flag){
            try{
                Scanner sc=new Scanner(System.in);
                ipt=sc.nextInt();
                flag=true;

                if(flag && ipt>limit || ipt<1){
                    System.out.println("choose the number b/w 1 to "+limit);
                    flag=false;
                }
            }
            catch(Exception e){
                System.out.println("enter only integer value");
                flag=false;
            }
        };
        return ipt;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to GPCET ATM Machine\n");
        System.out.println("1. Register \n2. Exit");
        System.out.println("Enter your choice :");
        int choice = takeIntegerInput(2);
    
        if (choice == 1) {
            Bankaccount b = new Bankaccount();
            b.register();
            while (true) {
                System.out.println("\n1. Login \n2. Exit");
                System.out.print("Enter your choice: ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("Welcome, bank " + b.name + ". Your service is our pleasure.");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5. Transaction History \n6. Exit");
                            System.out.print("Enter your choice: ");
                            int c = takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkbalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
    
}