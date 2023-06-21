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
        double[] balanceAfterPayment = calcBalances(principal, annualInterest, period);

        // displaying mortgage
        displayMortgage(mortgage);

        // displaying balanceAfterPayment
        displayPaymentSchedule(balanceAfterPayment);
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

        return principal
                *(monthlyInterest*Math.pow(1.0+monthlyInterest, nPayments))
                /(Math.pow(1.0+monthlyInterest, nPayments)-1);
    }

    private static double[] calcBalances(int principal, float annualInterest, byte period){
        // calculations
        float monthlyInterest = annualInterest/1200;
        short nTotalPayments = (short) (period * 12);
        double [] remainingBalance = new double[nTotalPayments];

        for (int paymentNum=1; paymentNum<=nTotalPayments; paymentNum++) {
            remainingBalance[paymentNum-1] = principal * ( (Math.pow(1 + monthlyInterest, nTotalPayments) - Math.pow(1 + monthlyInterest, paymentNum)) / (Math.pow(1 + monthlyInterest, nTotalPayments) - 1) );
        }

        return remainingBalance;
    }

    private static String convert2String(double amount){
        return NumberFormat.getCurrencyInstance().format(amount);
    }
    private static void displayMortgage(double mortgage) {
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + convert2String(mortgage));
    }

    private static void displayPaymentSchedule(double[] balanceAfterPayment){
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        for (double balance: balanceAfterPayment){
            System.out.println(convert2String(balance));
        }
    }
}