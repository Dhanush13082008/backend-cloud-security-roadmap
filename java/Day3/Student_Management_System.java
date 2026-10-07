import java.util.*;
class Student_Management_System{
  public static  void main(String[] args){
    Scanner in=new Scanner(System.in);
    String rollNo;
    String name;
    rollNo=in.nextLine();
    name=in.nextLine();
    int n=in.nextInt();
    double[] marks=new double[n];
    for(int i=0;i<n;i++){
      marks[i]=in.nextDouble();
      if(marks[i]<0||marks[i]>100){
        System.out.println("Invalid range of marks it should be between 0 and 100");
        i=i-1;
      }
    }Student s1=new Student(rollNo,name,marks);
    System.out.println("Average is : "+s1.average());
    System.out.println("Highest is : "+s1.highest());
    System.out.println("Lowest is : "+s1.lowest());
  }
}class Student{
  String rollNo;
  String name;
  double[] marks;
  Student(String rollNo,String name,double[] marks){
    this.rollNo=rollNo;
    this.name=name;
    int n=marks.length;
    this.marks=new double[n];
    for(int i=0;i<n;i++){ 
      this.marks[i]=marks[i];
    }
  }double average(){
    double sum=0.0;
    int n=marks.length;
    for(int i=0;i<n;i++){
      sum+=marks[i];
    }
    return sum/n;
  }double highest(){
    double high=0.0;
    int n=marks.length;
    for(int i=0;i<n;i++){
      if(high<marks[i]){
        high=marks[i];
      }
    }return high;
  }double lowest(){
    double low=100.01;
    int n=marks.length;
    for(int i=0;i<n;i++){
      if(low>marks[i]){
        low=marks[i];
      }
    }return low;
  }
}