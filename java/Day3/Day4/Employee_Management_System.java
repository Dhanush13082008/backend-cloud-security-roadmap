package Day4;
import java.util.*;
abstract class Employee{
  private String name;
  private String id;
  private double baseSalary;
  Employee(String name,String id,double baseSalary){
    this.name=name;
    this.id=id;
    this.baseSalary=baseSalary;
  }abstract double calculateSalary();
  void display(){
    System.out.println("ID of employee is :"+id);
    System.out.println("Name of employee is :"+name);
    System.out.println("Salary is :"+calculateSalary());
  }double getBase(){
    return baseSalary;
  }

}
class Developer extends Employee{
  Developer(String s,String s1,double a){
    super(s,s1,a);
  }@Override 
  double calculateSalary(){
    return getBase()-5000;
  }
}
class Intern extends Employee{
  Intern(String s,String s1,double a){
    super(s,s1,a);
  }@Override 
  double calculateSalary(){
    return getBase()+20000;
  }
}class Manager extends Employee{
  Manager(String s,String s1,double a){
    super(s,s1,a);
  }@Override 
  double calculateSalary(){
    return getBase()+30000;
  }
}

public class Employee_Management_System {

    public static void main(String[] args) {

        Employee[] e = new Employee[15];

        for (int i = 0; i < 15; i++) {

            if (i < 5) {
                e[i] = new Intern("Dhanush", "I10" + i, 30000 + i * 1000);

            } else if (i < 10) {
                e[i] = new Developer("Rahul", "D20" + i, 80000 + i * 2000);

            } else {
                e[i] = new Manager("Arjun", "M30" + i, 120000 + i * 3000);
            }
        }

        for (int i = 0; i < 15; i++) {
            e[i].display();
            System.out.println();
        }
    }
}