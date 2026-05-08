import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BSCS_EVE_B_SalesTotalHM {

    public static void main(String[] args) {

        File f1 = new File("C:\\Users\\dell\\Downloads\\SalesTotalHashMap\\salesevesession.txt");

        HashMap<String, Double> hm = new HashMap<>();

        try {
            Scanner inp = new Scanner(f1);

            // Skip header line
            if (inp.hasNextLine()) {
                inp.nextLine();
            }

            // Read file line by line
            while (inp.hasNextLine()) {

                String line = inp.nextLine().trim();

                // Skip empty line
                if (line.isEmpty()) {
                    continue;
                }

                // Split line using spaces/tabs
                String[] parts = line.split("\\s+");

                // Check valid line
                if (parts.length < 7) {
                    System.out.println("Invalid line skipped: " + line);
                    continue;
                }

                try {

                    // Rep ID
                    String repID = parts[6];

                    // Unit Price
                    double unitPrice = Double.parseDouble(parts[3]);

                    // Quantity
                    double quantity = Double.parseDouble(parts[4]);

                    // Amount
                    double amount = unitPrice * quantity;

                    // Store in HashMap
                    hm.put(repID, hm.getOrDefault(repID, 0.0) + amount);

                } catch (NumberFormatException e) {

                    System.out.println("Number format error: " + line);
                }
            }

            inp.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found!");
            return;
        }

        // Output
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║         TOTAL SALES BY REP ID               ║");
        System.out.println("╠══════════════════════════════════════════════╣");

        double grandTotal = 0;

        for (Map.Entry<String, Double> entry : hm.entrySet()) {

            System.out.printf("║ Rep ID: %-8s | Total Sales: %10.2f ║%n",
                    entry.getKey(), entry.getValue());

            grandTotal += entry.getValue();
        }

        System.out.println("╠══════════════════════════════════════════════╣");

        System.out.printf("║ GRAND TOTAL        : %18.2f ║%n", grandTotal);

        System.out.println("╚══════════════════════════════════════════════╝");
    }
}