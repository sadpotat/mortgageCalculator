public class Main {
    public static void main(String[] args) {
        // getting values
        int principal = (int) Console.readInput("Principal ($1K - $1M)", 1_000, 1_000_000);
        float annualInterest = (float) Console.readInput("Annual interest Rate", 0, 30);
        byte period = (byte) Console.readInput("Period (Years)", 0, 30);

        // creating objects with data
        var calculator = new CalculatePayments(principal, annualInterest, period);
        var report = new MortgageReport(calculator);

        // displaying mortgage
        report.displayMortgage();

        // displaying balanceAfterPayment
        report.displayPaymentSchedule();
    }

}