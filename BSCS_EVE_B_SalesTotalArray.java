import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BSCS_EVE_B_SalesTotalArray {

    public static void main(String[] args) {

        //File path 
        File f1 = new File("C:\\Users\\dell\\Downloads\\SalesTotalHashMap\\salesevesession.txt");

        //  Arrays
        String[] productNames = new String[100];
        double[] totalSales = new double[100];
        int count = 0;

        try {
            Scanner inp = new Scanner(f1);

            //  Skip header
            if (inp.hasNextLine()) {
                inp.nextLine();
            }

            //  Read file
            while (inp.hasNextLine()) {
                String line = inp.nextLine().trim();

                if (line.isEmpty()) continue;

                System.out.println(line); // input print

                String[] parts = line.split("\\s+");

                if (parts.length < 5) {
                    System.out.println("Invalid line skipped!");
                    continue;
                }

                //  Product Name 
                String productName = parts[1] + " " + parts[2];

                //  Values
                double unitPrice = Double.parseDouble(parts[3]);
                double quantity = Double.parseDouble(parts[4]);

                double amount = unitPrice * quantity;

                // Check existing product
                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (productNames[i].equals(productName)) {
                        totalSales[i] += amount;
                        found = true;
                        break;
                    }
                }

                //  Add new product
                if (!found) {
                    productNames[count] = productName;
                    totalSales[count] = amount;
                    count++;
                }
            }

            inp.close();

        } catch (FileNotFoundException e) {
            System.out.println(" File not found! Check path.");
            return;
        } catch (NumberFormatException e) {
            System.out.println(" Number format error in file.");
            return;
        }

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {

                if (productNames[j].compareTo(productNames[j + 1]) > 0) {

                    String tempName = productNames[j];
                    productNames[j] = productNames[j + 1];
                    productNames[j + 1] = tempName;
                    double tempSales = totalSales[j];
                    totalSales[j] = totalSales[j + 1];
                    totalSales[j + 1] = tempSales;
                }
            }
        }

        // Final Output
        System.out.println("\n----- TOTAL SALES -----");
        for (int i = 0; i < count; i++) {
            System.out.println(productNames[i] + " = " + totalSales[i]);
        }
    }
}