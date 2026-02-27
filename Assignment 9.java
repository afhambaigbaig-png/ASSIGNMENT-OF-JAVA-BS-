import java.util.Scanner;
class main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number");
        int num = sc.nextInt();
        int n=1;
        int a=0;
     

        while(n<=num){
        System.out.println(n);
        n=n+a;
        a=a+1;
       
        }
    } 
}
