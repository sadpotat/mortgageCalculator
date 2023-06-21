import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // getting values
        int principal = (int) readInput("Principal ($1K - $1M)", 1_000, 1_000_000);
        float annualInterest = (float) readInput("Annual interest Rate", 0, 30);
        byte period = (byte) readInput("Period (Years)", 0, 30);

        // calculation
        double mortgage = calcMortgage(principal, annualInterest, period);

        // formatting the output
        String mortStr = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortStr);
    }

    private static double readInput(
            String prompt,
            double lBound,
            double rBound) {
        Scanner scanner = new Scanner(System.in);
        double userInput;
        while (true) {
            System.out.print(prompt + ": ");
            userInput = scanner.nextDouble();
            if (userInput >= lBound && userInput <= rBound)
                break;
            System.out.println("Enter a value between " + lBound + " and " + rBound);
        }
        return userInput;
    }

    private static double calcMortgage(
            int principal,
            float annualInterest,
            byte period) {

        // calculations
        float monthlyInterest = annualInterest/1200;
        short nPayments = (short) (period * 12);

        double mortgage = principal
                *(monthlyInterest*Math.pow(1.0+monthlyInterest, nPayments))
                /(Math.pow(1.0+monthlyInterest, nPayments)-1);

        return mortgage;
    }
}