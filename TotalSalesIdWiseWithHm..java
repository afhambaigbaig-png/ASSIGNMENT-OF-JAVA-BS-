import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

class BSCS_EVE_B_IDWiseTotalHM
{
    public static void main(String[] args)
    {
        File f1 = new File("C:\\Users\\dell\\Documents\\JavaWork\\salesevesession.txt");

        HashMap<String, Double> hm = new HashMap<>();

        double grandTotal = 0;

        try
        {
            Scanner inp = new Scanner(f1);

            // Header Line
            String dl = inp.nextLine();

            System.out.println(dl);

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

                // ID Wise Total
                if (hm.containsKey(repID))
                {
                    double prevAmt = hm.get(repID);

                    amt += prevAmt;

                    hm.put(repID, amt);
                }
                else
                {
                    hm.put(repID, amt);
                }
            }

            inp.close();
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }

        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        finally
        {
            System.out.println("\n------ ID WISE TOTAL SALES ------");

            for (Map.Entry<String, Double> me : hm.entrySet())
            {
                System.out.println(me.getKey() + " --- " + me.getValue());
            }

            System.out.println("---------------------------------");

            System.out.println("GRAND TOTAL = " + grandTotal);
        }
    }
}