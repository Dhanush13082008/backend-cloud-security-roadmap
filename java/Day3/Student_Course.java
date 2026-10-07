import java.util.*;
public class Student_Course {
  int id;
  int[] arr=new int[6];
  int a=0;
  Student_Course(int id){
    this.id=id;
  }void registerCourse(Course c){
    if(a>=6){
      System.out.println("More than 6 registered");
      return;
    }
    for(int i=0;i<a;i++){
      if(arr[i]==c.idc){
        System.out.println("Already registered");
        return;
      }
    }
    if(c.no_left==0){
      System.out.println("NO slot left for this course "+c.idc);
    }else{
      arr[a]=c.idc;
      a++;
      c.no_left--;
    }
  }void dropCourse(Course c){
    for(int i=0;i<a;i++){
      if(arr[i]==c.idc){
        for(int j=i;j<a-1;j++){
          arr[j]=arr[j+1];
        }c.no_left++;
        a--;

      }
    }
  }
}class Course{
  int idc;
  int no_left=60;
  Course(int idc) {
        this.idc = idc;
  }
}
