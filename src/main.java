import java.util.Scanner;
import java.text.DecimalFormat;
public class main {
    public static void main (String[] args){
        System.out.println("Welcome to the helpful tip calculator! ");
        Scanner scan = new Scanner(System.in);

        System.out.println("Keep in mind that if you have a group of 6 or more, you will have to automatically have to pay an extra 18% of the check without the tip for gratuity.");
        System.out.println("<-------------------------------------------------------------------->");

        System.out.print("How many people are here with you today? ");
        int group = scan.nextInt();
        scan.nextLine();
        System.out.print("What's the tip percentage (exclude the percent sign)? ");
        int percent = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter a cost in dollars and cents for every food item (-1 to end): ");
        double cost = scan.nextDouble();
        double tempCost = cost;
        scan.nextLine();

        double totalCost = 0;

        // to find total price of items
        while (tempCost != -1) {
            System.out.print("Enter a cost in dollars and cents for every food item (-1 to end): ");
            tempCost = scan.nextDouble();
            totalCost += tempCost;
        }

        //  I learned how to round to the nearest hundredth using DecimalFormatter through https://www.baeldung.com/java-round-decimal-number

        // finding total cost without tip
        double totalNewCost = ((totalCost + cost) + 1);
        DecimalFormat f = new DecimalFormat("##.00"); // decimal format

        // calculate tip
        double percentDecimal = (double) percent / 100;
        double tip = totalNewCost * percentDecimal;
        DecimalFormat x = new DecimalFormat("##.00"); // decimal format

        // calculate total bill with tip
        double totalBill = totalNewCost + tip;
        DecimalFormat y = new DecimalFormat("##.00");

        // calculate per person cost before tip
        double personWithoutTip = totalNewCost / group;
        DecimalFormat z = new DecimalFormat("##.00");

        // calculate tip per person
        double tipPerPerson = tip / group;
        DecimalFormat t = new DecimalFormat("##.00");

        // calculate total cost per person
        double totalPerson = totalBill / group;
        DecimalFormat w = new DecimalFormat("##.00");

        System.out.println("<-------------------------------------------------------------------->");
        System.out.println("Total bill before tip: $" + f.format(totalNewCost));
        System.out.println("Total percentage: " + percent + "%");
        System.out.println("Total tip: $" + x.format(tip));
        System.out.println("Total bill with tip: $" + y.format(totalBill));
        System.out.println("Per person cost before tip: $" + z.format(personWithoutTip));
        System.out.println("Tip per person: $" + t.format(tipPerPerson));
        System.out.println("Total cost per person: $" + w.format(totalPerson));

        // calculating 18 percent of the check for those who have groups of 6 or more
        if (group >= 6) {
            double gratuity = totalNewCost * 0.18;
            DecimalFormat k = new DecimalFormat("##.00");
            double newTotalForSixOrMore = totalBill + gratuity;
            DecimalFormat h = new DecimalFormat("##.00");
            System.out.println("Total gratuity for groups of 6 or more: $" + k.format(gratuity));
            System.out.println("Total cost with tip and gratuity: $" + h.format(newTotalForSixOrMore));
        }
    }
}
