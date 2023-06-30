import java.util.Scanner;

public class Console {
    // creating a static scanner object so that a new instance is not created everytime we call a method
    private static Scanner scanner = new Scanner(System.in);

    public static double readInput(
            String prompt,
            double lBound,
            double rBound) {
//        Scanner scanner = new Scanner(System.in);
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
}
