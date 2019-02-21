import java.util.*;

class Account{
    String name,acc_type;
    int Acc_num,Acc_Balance;
    Account(){
      
    }
        Account(String n,int acc_num,int b,String a_t){
            name=n;
            Acc_num=acc_num;
            Acc_Balance=b;
            acc_type=a_t;
        }
}

class create_account extends Account{
    create_account(String n,int acc_num,int b,String a_t){
            name=n;
            Acc_num=acc_num;
            Acc_Balance=b;
            acc_type=a_t;
    }
    create_account(){
        super();
    }
        
    void insert(String n,int acc_num,String a_t){  
        name=n;
        acc_type=a_t;
        Acc_num=acc_num;
        Acc_Balance=0;
    }
    
    void display_details(){
        System.out.println("Depositor Name :" +name);
        System.out.println("Account Number : "+Acc_num);
        System.out.println("Account Balance : "+Acc_Balance);
        System.out.println("Account Type : "+acc_type);
    }
        void credit(int money){                 
                Acc_Balance=Acc_Balance+money;    
		System.out.println("The current balance in your account is: "+Acc_Balance);
        }
        void debit(int mon){
                Acc_Balance=Acc_Balance-mon;
                System.out.println("The current balance in your account is: "+Acc_Balance);
        }
} 

      
public class MainServer {
    public static void main(String args[]){
        String user_name=null,type;
        type = null;
        int balance=0,tmp=0;
        int withd=0;
//generate Random Account Number 
int aNumber = 0; 
aNumber = (int)((Math.random() * 9000)+1000); 

        create_account user = new create_account("user",0,0,"savings");
    
            Scanner in = new Scanner(System.in);
            Scanner strng=new Scanner(System.in);
            int userChoice;
            boolean quit = false;

            do {
                  System.out.println("1. Create Account");
                  System.out.println("2. Deposit money");
                  System.out.println("3. Withdraw money");
                  System.out.println("4. Check balance");
                  System.out.println("5. Display Account Details");
                  System.out.println("0. to quit: \n");
                  System.out.print("Enter Your Choice : ");
                  userChoice = in.nextInt();
                  switch (userChoice) {
                      
                  case 1:
                        System.out.print("Enter your Name : ");
                        user_name=strng.nextLine(); 
                        System.out.print("Enter Account Type : ");
                        type=in.next();
                        user.insert(user_name, aNumber, type);  // inserted 
                        System.out.println("\n\tYour Account Details\n\tDont Forget Account Number\n");
                        System.out.println("**************************");                       
                        user.display_details();
                        break;
                      
                case 2: 
                    System.out.print("Enter your account Number : ");
                    tmp=in.nextInt();
                 if(tmp==user.Acc_num){
                 System.out.print("Enter Amount Of Money : ");
                 balance=in.nextInt();
                 user.credit(balance);
                 System.out.println("\t Successfully Deposited.");
              }                
                     else
                    System.out.println("Wrong Account Number.");          
                   break;
                    
                  case 3:                    
                     System.out.print("Enter your account Number : ");
                      tmp=in.nextInt();
                      
                          if(tmp==user.Acc_num){                         
                             if(user.Acc_Balance==0)
                             System.out.print("Your Account is Empty.");
                             
                             else{
                             System.out.print("Enter Amount Of Money : ");   
                             withd=in.nextInt();  
                             
                             if(withd>user.Acc_Balance){
                             System.out.print("Enter Valid Amount of Money : ");
                             withd=in.nextInt();
                             }
                             else
                             System.out.println("The Amount withdrawn is "+withd);
                             user.debit(withd);
                             }
                          }
                             else
                             System.out.println("Wrong Account Number.");  
                        break;
     
                  case 4:

                      System.out.print("Enter your Account Number : ");
                      tmp=in.nextInt();
                      
                             if(tmp==user.Acc_num){
                             System.out.println("Your Current Balance : "+user.Acc_Balance);
                             }
                             else
                             System.out.println("Wrong Account Number.");                         
                      break;
                      
                  case 5:
                          
                      System.out.print("Enter your Account Number :");
                      tmp=in.nextInt();                     
                             if(tmp==user.Acc_num){                               
                             user.display_details();                             
                        }else
                             System.out.println("Wrong Accoount Number.");
                             
                      break;
                  case 0:
                        quit = true;
                        break;
                  default:
                        System.out.println("Wrong Choice.");
                        break;
                  }
                  System.out.println("\n");
            } while (!quit);
            System.out.println("Thanks !");
             
     }
    
}