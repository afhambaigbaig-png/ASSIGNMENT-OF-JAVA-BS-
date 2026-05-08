import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BSCS_EVE_B_ArrayId {

    public static void main(String[] args) {

        File f1 = new File("C:\\Users\\dell\\Downloads\\SalesTotalHashMap\\salesevesession.txt");

        // Arrays
        String[] repIDs = new String[100];
        double[] totalSales = new double[100];

        int count = 0;

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
                    double unitPrice =
                            Double.parseDouble(parts[3]);

                    // Quantity
                    double quantity =
                            Double.parseDouble(parts[4]);

                    // Amount
                    double amount = unitPrice * quantity;

                    // Check if ID already exists
                    boolean found = false;

                    for (int i = 0; i < count; i++) {

                        if (repIDs[i].equals(repID)) {

                            totalSales[i] =
                                    totalSales[i] + amount;

                            found = true;

                            break;
                        }
                    }

                    // New ID
                    if (!found) {

                        repIDs[count] = repID;

                        totalSales[count] = amount;

                        count++;
                    }

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Number format error: " + line);
                }
            }

            inp.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found!");

            return;
        }

        // Output
        System.out.println(
                "\n╔══════════════════════════════════════════════╗");

        System.out.println(
                "║         TOTAL SALES BY REP ID               ║");

        System.out.println(
                "╠══════════════════════════════════════════════╣");

        double grandTotal = 0;

        for (int i = 0; i < count; i++) {

            System.out.printf(
                    "║ Rep ID: %-8s | Total Sales: %10.2f ║%n",
                    repIDs[i],
                    totalSales[i]);

            grandTotal += totalSales[i];
        }

        System.out.println(
                "╠══════════════════════════════════════════════╣");

        System.out.printf(
                "║ GRAND TOTAL        : %18.2f ║%n",
                grandTotal);

        System.out.println(
                "╚══════════════════════════════════════════════╝");
    }
}