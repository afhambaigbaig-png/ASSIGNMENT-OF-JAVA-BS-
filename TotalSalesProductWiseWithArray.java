import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class BSCS_EVE_B_SalesTotalArray
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
            String[] productNames = new String[100];
            double[] totalSales = new double[100];

            int count = 0;

            double grandTotal = 0;

            while (inp.hasNextLine())
            {
                dl = inp.nextLine();

                System.out.println(dl);

                String[] parts = dl.split("\t");

                String prodName = parts[1];

                double uPrice = Double.parseDouble(parts[2]);

                double qty = Double.parseDouble(parts[3]);

                double amt = uPrice * qty;

                // Grand Total
                grandTotal += amt;

                boolean found = false;

                // Check if product already exists
                for (int i = 0; i < count; i++)
                {
                    if (productNames[i].equals(prodName))
                    {
                        totalSales[i] += amt;
                        found = true;
                        break;
                    }
                }

                // If product not found
                if (found == false)
                {
                    productNames[count] = prodName;
                    totalSales[count] = amt;
                    count++;
                }
            }

            inp.close();

            // Product Wise Total
            System.out.println("\n------ PRODUCT WISE TOTAL SALES ------");

            for (int i = 0; i < count; i++)
            {
                System.out.println(productNames[i] + " --- " + totalSales[i]);
            }

            System.out.println("--------------------------------------");

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