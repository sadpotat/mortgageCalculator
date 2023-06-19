import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // getting values
        Scanner scanner = new Scanner(System.in);

        int principal;
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000");
        }

        float annualInterest;
        while (true) {
            System.out.print("Annual interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0f && annualInterest <= 30f)
                break;
            System.out.println("Enter a number greater than 0 and less than 30");
        }

        byte period;
        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextByte();
            if (period >= 1 && period <= 30)
                break;
            System.out.println("Enter a number greater than 1 and less than 30");
        }

        // calculations
        float monthlyInterest = annualInterest/1200;
        int nPayments = period * 12;

        double mortgage = principal
                *(monthlyInterest*Math.pow(1.0+monthlyInterest, nPayments))
                /(Math.pow(1.0+monthlyInterest, nPayments)-1);

        // formatting the output
        String mortStr = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortStr);
    }
}