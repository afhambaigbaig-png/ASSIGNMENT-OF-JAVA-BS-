import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class BSCS_EVE_B_ProductSales {

    public static void main(String[] args) {

        File f1 = new File("C:\\Users\\dell\\Downloads\\SalesTotalHashMap\\salesevesession.txt");

        HashMap<String, Double> hm = new HashMap<>();

        try {
            Scanner inp = new Scanner(f1);

            // Skip header 
            if (inp.hasNextLine()) {
                inp.nextLine();
            }

            // Read file line by line
            while (inp.hasNextLine()) {
                String line = inp.nextLine().trim();

                // Empty line skip
                if (line.isEmpty()) continue;

                System.out.println(line); // input print

                String[] parts = line.split("\\s+");

                
                if (parts.length < 5) {
                    System.out.println("Invalid line skipped!");
                    continue;
                }

                // Product Name (2 words)
                String productName = parts[1] + " " + parts[2];

                // Convert values
                double unitPrice = Double.parseDouble(parts[3]);
                double quantity = Double.parseDouble(parts[4]);

                // Calculate amount
                double amount = unitPrice * quantity;

                // Add into HashMap
                hm.put(productName, hm.getOrDefault(productName, 0.0) + amount);
            }

            inp.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found! Check path.");
        } catch (NumberFormatException e) {
            System.out.println("Number format error in file.");
        }

        // Output result
        System.out.println("\n----- TOTAL SALES -----");
        for (Map.Entry<String, Double> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}