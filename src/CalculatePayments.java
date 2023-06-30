public class CalculatePayments {
    private int principal;
    private float annualInterest;
    private byte period;

    public CalculatePayments(int principal, float annualInterest, byte period) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.period = period;
    }

    public double calcMortgage() {

        // calculations
        float monthlyInterest = getMonthlyInterest();
        short nPayments = getnPayments();

        return principal
                * (monthlyInterest * Math.pow(1.0 + monthlyInterest, nPayments))
                / (Math.pow(1.0 + monthlyInterest, nPayments) - 1);
    }

    public double[] calcBalances() {
        // calculations
        float monthlyInterest = getMonthlyInterest();
        short nTotalPayments = getnPayments();
        double[] remainingBalance = new double[nTotalPayments];

        for (int paymentNum = 1; paymentNum <= nTotalPayments; paymentNum++) {
            remainingBalance[paymentNum - 1] = principal * ((Math.pow(1 + monthlyInterest, nTotalPayments) - Math.pow(1 + monthlyInterest, paymentNum)) / (Math.pow(1 + monthlyInterest, nTotalPayments) - 1));
        }

        return remainingBalance;
    }

    private short getnPayments() {
        return (short) (period * 12);
    }

    private float getMonthlyInterest() {
        return annualInterest / 1200;
    }

}
