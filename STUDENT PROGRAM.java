import java.util.Scanner;
class studentresult{
    
    // total function;
    public static int total(int chem, int phy, int math, int urdu, int eng, int isl){
        return chem+phy+math+urdu+eng+isl;
    }
    // average function;
    public static double avg(int t){
      return t/3.0;
    }
    // grade function
    public static String grade(double avg){
        if(avg>=80)
        return "A";
        else if(avg>=60)
        return "B";
        else if(avg>=40)
        return "C";
        else
        return "Fail";
    }
    public static double percentage(int total){
        return (total/600.0)*100;
    }
    // Diplay result;
    public static void display(String name, int total, double avg,String grade,double percent){
      System.out.println("\n---STUDENT NAME--- " );
      System.out.println("NAME: "+ name);
      System.out.println("TOTAL MARKS: "+  total);
      System.out.println("AVERAGE: "+  avg);
      System.out.println("GRADE: "+  grade);
      System.out.println("PERCENTAGE: " + percent);

    }
    // Main function;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // input values;
        System.out.print("Enter the Student name ");
        String name= sc.nextLine();
        System.out.print("Enter marks chem:  ");
        int chem= sc.nextInt();
        System.out.print("Enter marks phy:  ");
        int phy= sc.nextInt();
         System.out.print("Enter marks math:  ");
        int math= sc.nextInt();
         System.out.print("Enter marks urdu:  ");
        int urdu= sc.nextInt();
         System.out.print("Enter marks eng:  ");
        int eng= sc.nextInt();
         System.out.print("Enter marks isl:  ");
        int isl= sc.nextInt();
        // Function call;
       int total = total(chem,phy,math,urdu,eng,isl);
        double avg = avg(total);
         String grade = grade(avg);
         double percent= percentage(total);
 
         display(name,total,avg,grade,percent);
    }
}
