import java.util.Scanner;
import java.util.InputMismatchException;

public class financialCalculator {
    public static double calc_wealth_by_year(double currWealth, int monthlySavings, double rateOfReturn, int years) {
        double totalSavings = currWealth;
        for (int i = 0; i < years; i++) {
            double interestEarned = totalSavings * (rateOfReturn / 100);
            totalSavings += interestEarned + (monthlySavings * 12);
        }
        System.out.println(
                "Your total wealth after " + years + " years will be: $" + String.format("%.2f", totalSavings));
        return totalSavings;
    }

    public static double calcYearsToFinFreedom(double currWealth, int monthlySavings, double rateOfReturn,
            double targetWealth) {
        double totalSavings = currWealth;
        int years = 0;

        while (true) {
            double interestEarned = totalSavings * (rateOfReturn / 100);
            totalSavings += interestEarned + (monthlySavings * 12);
            years++;
            if (totalSavings >= targetWealth) {
                break;
            }
        }
        System.out.println("It will take you " + years + " years to reach financial freedom of: $"
                + String.format("%.2f", targetWealth));
        return years;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to the Financial Calculator!");
        System.out.println("There are 2 programs in this calculator: " +
                "\n 1. Calculate wealth by year" +
                "\n 2. Calculate years to financial freedom");

        int userChoice = -1;
        while (userChoice != 1 && userChoice != 2) {
            System.out.print("\nWhich program would you like to use? (Enter 1 or 2): ");
            try {
                userChoice = scnr.nextInt();
                if (userChoice != 1 && userChoice != 2) {
                    System.out.println("Invalid choice. Please enter either 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scnr.nextLine();
            }
        }

        if (userChoice == 1) {
            double currWealth;
            while (true) {
                System.out.print("\nEnter your current wealth: ");
                try {
                    currWealth = scnr.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.nextLine();
                }
            }

            int monthlySavings;
            while (true) {
                System.out.print("Enter your monthly savings: ");
                try {
                    monthlySavings = scnr.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.nextLine();
                }
            }

            double rateOfReturn;
            while (true) {
                System.out.print("Enter the rate of return on your investments: ");
                try {
                    rateOfReturn = scnr.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.nextLine();
                }
            }

            int years;
            while (true) {
                System.out.print("Enter the number of years you would like to calculate: ");
                try {
                    years = scnr.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.nextLine();
                }
            }

            calc_wealth_by_year(currWealth, monthlySavings, rateOfReturn, years);
            System.out.println("Thank you for using the Financial Calculator!");

        } else {
            double currWealth;
            while (true) {
                System.out.print("Enter your current wealth: ");
                try {
                    currWealth = scnr.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.nextLine();
                }
            }

            int monthlySavings;
            while (true) {
                System.out.print("Enter your monthly savings: ");
                try {
                    monthlySavings = scnr.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.nextLine();
                }
            }

            double rateOfReturn;
            while (true) {
                System.out.print("Enter the rate of return on your investments: ");
                try {
                    rateOfReturn = scnr.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.nextLine();
                }
            }

            double targetWealth;
            while (true) {
                System.out.print("Enter your target wealth: ");
                try {
                    targetWealth = scnr.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.nextLine();
                }
            }

            calcYearsToFinFreedom(currWealth, monthlySavings, rateOfReturn, targetWealth);
            System.out.println("Thank you for using the Financial Calculator!");

        }
    }
}