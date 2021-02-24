import java.util.*;
interface Account{
public void prom(String b);
 public int getAccno();
 public void getValue();
}
class Bank implements Account
{        int accno,bal;
         String cname,addr;
//Implementation of no-arg constructor 
    Bank(){}
        public void getValue()
        {
                Scanner sin=new Scanner(System.in);
                System.out.print("Enter the Customer name:");
                cname=sin.nextLine();
                System.out.print("Enter the Customer address: ");
                addr=sin.nextLine();
                System.out.print("Enter the accno:");
                accno=sin.nextInt();
                System.out.println("Enter the balance:");
                bal=sin.nextInt();
        }
      public void display()
        {System.out.println("Accno:"+accno);
               System.out.println("Customer name:"+cname);
                System.out.println("Customer address:"+addr);
                System.out.println("Balance amount:" +bal);
      }
      public void Deposit(int x)
        {
                bal+=x;
        }
       public void withdraw(int x)
        {
                if(bal>x)
                        bal=bal-x;
                else
                        System.out.println("Ur balance is only "+bal);
        }
 public int getAccno()
        {
                return accno;
        }

//Implementation of Method overloading 
public void prom(String b){
 System.out.println("Hello customer:" +b);
}
 public void prom(){
 System.out.println("Welcome to this Bank");}
}
//Implementation of Inheritance 
public class BankApp extends Bank
{

        public static void main(String arg[])
        {
                
  BankApp  ob = new BankApp();
ob.prom();
  Bank  obj = new Bank();

Bank b[];
                int n,accno,amt,ch,i,temp=0;
          Scanner sin=new Scanner(System.in);
                System.out.println("Enter the n value:");
                n=sin.nextInt();
                b=new Bank[n];

            for(i=0;i<n;i++)
                        b[i]=new Bank();
                for(i=0;i<n;i++)
                        b[i].getValue();
obj.prom("select the choice");
                do
                {

                System.out.println("1.Deposit");
                System.out.println("2.WithDraw");
                System.out.println("3.Display all ");
                 System.out.println("4.exit");
                System.out.print("Enter ur choice:");
                ch=sin.nextInt();
                switch(ch)
                {
                        case 1:
                                System.out.print("Enter the accno:");
                                accno=sin.nextInt();
                                System.out.print("Enter the amt:");
                                amt=sin.nextInt();
                                                      for(i=0;i<b.length;i++)
                                {
                                        if(accno==b[i].getAccno())
                                        {
                                                b[i].Deposit(amt);
                                                b[i].display();
                                                temp=10;
                                        }
                                }
                                if(temp==0)
                                        System.out.println("Enter the correct accno");
                                break;
                        case 2:
                                System.out.print("Enter the accno:");
                                accno=sin.nextInt();
                                System.out.print("Enter the amount to be withdraw:");
                                amt=sin.nextInt();
                                for(i=0;i<b.length;i++)
                                {
                                        if(accno==b[i].getAccno())
                                        {
                                               b[i].withdraw(amt);
                                                temp=10;
                                        }
                                }
                                if(temp==0)
                                        System.out.println("Enter the correct accno");
                                break;
                        case 3:
                                for(i=0;i<b.length;i++)
                                b[i].display();
                                break;
                     
                          case 4:
                                 break;
                }
                temp=0;
                System.out.print("Do u want to continue (y-1)(n-0):");
                ch=sin.nextInt();
                }while(ch==1);
        }
}
