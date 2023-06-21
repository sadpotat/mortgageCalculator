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
        double[] paymentSchedule = calcPayments(principal, annualInterest, period);

        // displaying mortgage
        displayMortgage(mortgage);

        // displaying paymentSchedule
        displayPaymentSchedule(paymentSchedule);
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

    private static double[] calcPayments(int principal, float annualInterest, byte period){
        // calculations
        float monthlyInterest = annualInterest/1200;
        short nTotalPayments = (short) (period * 12);
        double [] remainingBalance = new double[nTotalPayments];

        for (int i=1; i<=nTotalPayments; i++) {
            remainingBalance[i-1] = principal * ( (Math.pow(1 + monthlyInterest, nTotalPayments) - Math.pow(1 + monthlyInterest, i)) / (Math.pow(1 + monthlyInterest, nTotalPayments) - 1) );
        }
        return remainingBalance;
    }

    private static String convert2String(double amount){
        return NumberFormat.getCurrencyInstance().format(amount);
    }
    private static void displayMortgage(double mortgage) {
        System.out.println(" ");
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + convert2String(mortgage));
    }

    private static void displayPaymentSchedule(double[] paymentSchedule){
        System.out.println(" ");
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        int arrayLength = paymentSchedule.length;
        for (int i=0; i<arrayLength; i++){
            System.out.println(convert2String(paymentSchedule[i]));
        }
    }
}