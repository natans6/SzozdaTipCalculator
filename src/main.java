import java.util.Scanner;
import java.text.DecimalFormat;
public class main {
    public static void main (String[] args){
        System.out.println("Welcome to the helpful tip calculator! ");
        Scanner scan = new Scanner(System.in);

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

        while (tempCost != -1) {
            System.out.print("Enter a cost in dollars and cents for every food item (-1 to end): ");
            tempCost = scan.nextDouble();
            totalCost += tempCost;

        }
        double totalNewCost = ((totalCost + cost) + 1);
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println("Total bill before tip: " + f.format(totalNewCost));


    }
}
