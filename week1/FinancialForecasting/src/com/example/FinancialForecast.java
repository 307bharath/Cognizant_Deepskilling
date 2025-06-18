package FinancialForecasting.src.com.example;

import java.util.Scanner;

public class FinancialForecast {
   
    // Recursive method to calculate future value
    public static double futureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return futureValue(presentValue * (1 + growthRate), growthRate, periods - 1); // Recursive call
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Financial Forecasting Application");
        System.out.println("Enter the present value:");
        double presentValue = sc.nextDouble();
        System.out.println("Enter the growth rate (as a decimal):");
        double growthRate = sc.nextDouble();
        System.out.println("Enter the number of periods:");
        int periods = sc.nextInt();
        sc.close();

        double result = futureValue(presentValue, growthRate, periods);
        System.out.printf("Future Value after %d periods: %.2f\n", periods, result);
    }
}
