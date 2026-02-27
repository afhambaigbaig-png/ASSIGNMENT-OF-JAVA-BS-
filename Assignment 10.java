import java.util.Scanner;

class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        double pop[] = new double[10];
        double t = 0;
        int c = 0;
        double x;

        System.out.println("Enter the population (negative to stop): ");

        while (true) { 
            x = sc.nextDouble();

            if(x < 0){
                break;
            }

            if(c == 10){
                System.out.println("Array limit reached!");
                break;
            }

            pop[c] = x;
            t = t + x;
            c++;
        }

        if(c == 0){
            System.out.println("No data Entered");
        } 
        else{
            double avg = t / c;

            System.out.println("\nAll population values:");
            for(int i = 0; i < c; i++) {
                System.out.println(pop[i]);
            }

            System.out.println("\nAverage = " + avg);

            System.out.println("\nAbove Average:");
            for(int i = 0; i < c; i++){
                if(pop[i] > avg){
                    System.out.println(pop[i]);
                }
            }
        }

        sc.close();
    }
}