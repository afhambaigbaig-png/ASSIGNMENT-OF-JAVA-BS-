import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class BSCS_EVE_B_IDWiseTotalArray
{
    public static void main(String[] args)
    {
        File f1 = new File("C:\\Users\\dell\\Documents\\JavaWork\\salesevesession.txt");

        try
        {
            Scanner inp = new Scanner(f1);

            // Header Line
            String dl = inp.nextLine();

            System.out.println(dl);

            // Arrays
            String[] repIDs = new String[100];

            double[] totalSales = new double[100];

            int count = 0;

            double grandTotal = 0;

            while (inp.hasNextLine())
            {
                dl = inp.nextLine();

                System.out.println(dl);

                String[] parts = dl.split("\t");

                // Columns
                double uPrice = Double.parseDouble(parts[2]);

                double qty = Double.parseDouble(parts[3]);

                String repID = parts[5];

                // Amount
                double amt = uPrice * qty;

                // Grand Total
                grandTotal += amt;

                boolean found = false;

                // Check existing ID
                for (int i = 0; i < count; i++)
                {
                    if (repIDs[i].equals(repID))
                    {
                        totalSales[i] += amt;

                        found = true;

                        break;
                    }
                }

                // New ID
                if (found == false)
                {
                    repIDs[count] = repID;

                    totalSales[count] = amt;

                    count++;
                }
            }

            inp.close();

            // ID Wise Total
            System.out.println("\n------ ID WISE TOTAL SALES ------");

            for (int i = 0; i < count; i++)
            {
                System.out.println(repIDs[i] + " --- " + totalSales[i]);
            }

            System.out.println("---------------------------------");

            // Grand Total
            System.out.println("GRAND TOTAL = " + grandTotal);
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }

        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}