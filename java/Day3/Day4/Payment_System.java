package Day4;
import java.util.*;
class payments{
  static double balance;
  int id;
  payments(int id){
    this.id=id;
    
  }static void setbala(double amount){
    balance=amount;
  }void dispaly(){
    System.out.println("Remaining balance is :"+balance);
  }
}
class UPI extends payments{
  int amount;
  UPI(int id,int amount){
    super(id);
    this.amount=amount;
    if(balance-amount>=0){
    balance=balance-amount;
  }
  }
  
}
class Credit extends payments{
  int amount;
  Credit(int id,int amount){
    super(id);
    this.amount=amount;
    if(balance-amount-15>=0){
    balance=balance-amount-15;
  }
  }
  
}
class net extends payments{
  int amount;
  net(int id,int amount){
    super(id);
    this.amount=amount;
    if(balance-amount-30>=0){
    balance=balance-amount-30;
  }
  }
  
}
public class Payment_System {
    public static void main(String[] args) {

        payments.setbala(10000);

        UPI u = new UPI(101, 2000);
        u.dispaly();

        Credit c = new Credit(102, 3000);
        c.dispaly();

        net n = new net(103, 1000);
        n.dispaly();
    }
}
