import java.util.Scanner;

public class main {
    public static void main (String[] args){
        System.out.println("Welcome to the helpful tip calculator! ");
        Scanner scan = new Scanner(System.in);

        System.out.print("How many people are here with you today? ");
        int group = scan.nextInt();
        System.out.print("What's the tip percentage (exclude the percent sign)? ");
        int percent = scan.nextInt();

        System.out.print("Enter a cost in dollars and cents for every food item (-1 to end): ");
        double cost = scan.nextDouble();
        cost = (int) (cost * 100);
        int totalCost = 0;

        while (cost != -1) {
            System.out.print("Enter a cost in dollars and cents for every food item (-1 to end): ");
            cost = scan.nextDouble();
            cost = (int) (cost * 100);
            if (cost == -100.0){
                cost = -1;
            }
            totalCost += cost;
            System.out.println(totalCost);
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Total bill before tip: " + ((totalCost) / 100));
    }
}
