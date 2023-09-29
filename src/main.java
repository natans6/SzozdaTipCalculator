import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
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

        System.out.print("Enter the item: ");
        String item1 = scan.nextLine();

        double totalCost = 0;

        // I learned how to make array lists from here: https://www.youtube.com/watch?v=pTAda7qU4LY
        ArrayList itemsList = new ArrayList();
        itemsList.add(item1);

        // to find total price of items
        while (tempCost != -1) {
            System.out.print("Enter a cost in dollars and cents for every food item (-1 to end): ");
            tempCost = scan.nextDouble();
            totalCost += tempCost;
            scan.nextLine();
            if (tempCost != -1) {
                System.out.print("Enter the item: ");
                String item = scan.nextLine();
                itemsList.add(item);
            }
        }

        //  I learned how to round to the nearest hundredth using DecimalFormatter through https://www.baeldung.com/java-round-decimal-number
        DecimalFormat x = new DecimalFormat("##.00");

        // finding total cost without tip
        double totalNewCost = ((totalCost + cost) + 1);

        // calculate tip
        double percentDecimal = (double) percent / 100;
        double tip = totalNewCost * percentDecimal;

        // calculate total bill with tip
        double totalBill = totalNewCost + tip;

        // calculate per person cost before tip
        double personWithoutTip = totalNewCost / group;

        // calculate tip per person
        double tipPerPerson = tip / group;

        // calculate total cost per person
        double totalPerson = totalBill / group;

        // prints out the necessary values
        System.out.println("<-------------------------------------------------------------------->");
        System.out.println("Total bill before tip: $" + x.format(totalNewCost));
        System.out.println("Total percentage: " + percent + "%");
        System.out.println("Total tip: $" + x.format(tip));
        System.out.println("Total bill with tip: $" + x.format(totalBill));
        System.out.println("Per person cost before tip: $" + x.format(personWithoutTip));
        System.out.println("Tip per person: $" + x.format(tipPerPerson));
        System.out.println("Total cost per person: $" + x.format(totalPerson));

        // calculating 18 percent of the check for those who have groups of 6 or more
        if (group >= 6) {
            double gratuity = totalNewCost * 0.18;
            double newTotalForSixOrMore = totalBill + gratuity;
            System.out.println("Total gratuity for groups of 6 or more: $" + x.format(gratuity));
            System.out.println("Total cost with tip and gratuity: $" + x.format(newTotalForSixOrMore));
        }

        System.out.println("<-------------------------------------------------------------------->");
        // I  learned how to print the elements on separate lines from here: https://stackoverflow.com/questions/12887857/display-each-list-element-in-a-separate-line-console
        System.out.println("Items ordered: ");
        itemsList.forEach(System.out::println);
    }
}
