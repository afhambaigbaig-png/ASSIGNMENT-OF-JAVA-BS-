import java.util.Scanner;

 class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

     
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nSum of each row:");
        for(int i = 0; i < rows; i++) {
            int rowSum = 0;
            for(int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Row " + i + " sum = " + rowSum);
        }

        
        System.out.println("\nSum of each column:");
        for(int j = 0; j < cols; j++) {
            int colSum = 0;
            for(int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Column " + j + " sum = " + colSum);
        }

        if(rows == cols) {
            int mainDiagonalSum = 0;
            int reverseDiagonalSum = 0;

            for(int i = 0; i < rows; i++) {
                mainDiagonalSum += matrix[i][i];
                reverseDiagonalSum += matrix[i][rows - 1 - i];
            }

            System.out.println("\nMain Diagonal Sum = " + mainDiagonalSum);
            System.out.println("Reverse Diagonal Sum = " + reverseDiagonalSum);
        }

        sc.close();
    }
}


