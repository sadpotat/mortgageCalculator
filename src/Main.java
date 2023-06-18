import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // getting values
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual interest Rate: ");
        float annualInterest = scanner.nextFloat();

        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();


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
