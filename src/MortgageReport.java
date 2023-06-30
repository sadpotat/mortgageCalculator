import java.text.NumberFormat;

public class MortgageReport {
    private CalculatePayments calculator;

    public MortgageReport(CalculatePayments calculator) {
        this.calculator = calculator;
    }

    public String convert2String(double amount){
        return NumberFormat.getCurrencyInstance().format(amount);
    }

    public void displayMortgage() {
        double mortgage = calculator.calcMortgage();
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + convert2String(mortgage));
    }

    public void displayPaymentSchedule(){
        double[] balanceAfterPayment = calculator.calcBalances();
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("----------------");
        for (double balance: balanceAfterPayment){
            System.out.println(convert2String(balance));
        }
    }
}
