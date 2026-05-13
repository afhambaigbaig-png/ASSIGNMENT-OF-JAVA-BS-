import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

class BSCS_EVE_B_SalesTotalHM
{
    public static void main(String[] args)
    {
        File f1 = new File("C:\\Users\\dell\\Documents\\JavaWork\\salesevesession.txt");

        Scanner inp;
        String dl;

        HashMap<String, Double> hm = new HashMap<>();

        double grandTotal = 0;

        try
        {
            inp = new Scanner(f1);

            // Header line read
            dl = inp.nextLine();
            System.out.println(dl);

            String[] parts;

            String prodName;
            double qty, amt, uPrice;

            while (inp.hasNextLine())
            {
                dl = inp.nextLine();

                System.out.println(dl);

                parts = dl.split("\t");

                prodName = parts[1];

                uPrice = Double.parseDouble(parts[2]);

                qty = Double.parseDouble(parts[3]);

                amt = qty * uPrice;

                // Grand Total
                grandTotal += amt;

                // Product Wise Total
                if (hm.containsKey(prodName))
                {
                    double prevAmt = hm.get(prodName);

                    amt += prevAmt;

                    hm.put(prodName, amt);
                }
                else
                {
                    hm.put(prodName, amt);
                }
            }

            inp.close();
        }

        catch (FileNotFoundException fnfe)
        {
            System.out.println("File is inaccessible");
        }

        catch (NoSuchElementException nsee)
        {
            System.out.println("No more data in file");
        }

        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        finally
        {
            System.out.println("\n------ PRODUCT WISE TOTAL SALES ------");

            for (Map.Entry<String, Double> me : hm.entrySet())
            {
                System.out.println(me.getKey() + " --- " + me.getValue());
            }

            System.out.println("--------------------------------------");

            System.out.println("GRAND TOTAL = " + grandTotal);
        }
    }
}