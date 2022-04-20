import java.util.Scanner;

public class SafeInput {
    /**
     * @param pipe   - a Scanner opened to read from System.in
     * @param prompt - prompt for the user
     * @return - a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print(prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    /**
     * @param pipe   - a Scanner opened to read from System.in
     * @param prompt - prompt for the user
     * @return - a number that is an integer
     */
    public static int getInt(Scanner pipe, String prompt) {
        boolean done = false;
        int inputInt = 0;
        String trash = "";

        do {
            System.out.print(prompt);
            if (pipe.hasNextInt()) {
                inputInt = pipe.nextInt();

                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter a valid integer, not: " + trash);
            }
        } while (!done);

        return inputInt;
    }

    /**
     * @param pipe   - a Scanner opened to read from System.in
     * @param prompt - prompt for the user
     * @return - a number that is a double
     */
    public static double getDouble(Scanner pipe, String prompt) {
        boolean done = false;
        double inputDouble = 0;
        String trash = "";

        do {
            System.out.print(prompt);
            if (pipe.hasNextDouble()) {
                inputDouble = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter a valid double not: " + trash);
            }
        } while (!done);

        return inputDouble;
    }

    /**
     * @param pipe   - a Scanner opened to read from System.in
     * @param prompt - prompt for the user
     * @param low    - low number in range
     * @param high   - high number in range
     * @return - an integer that is within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        int rangeInt = 0;
        String trash = "";

        do {
            System.out.print(prompt);
            if (pipe.hasNextInt()) {
                rangeInt = pipe.nextInt();
                pipe.nextLine();

                if (rangeInt >= low && rangeInt <= high) {
                    done = true;
                } else {
                    System.out.println("Enter a valid number within the range, not: " + rangeInt);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter a valid number within the range, not: " + trash);
            }
        } while (!done);
        return rangeInt;
    }

    /**
     * @param pipe   - a Scanner opened to read from System.in
     * @param prompt - prompt for the user
     * @param low    - low number in range
     * @param high   - high number in range
     * @return - a double that is within the range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        boolean done = false;
        double rangeDouble = 0;
        String trash = "";

        do {
            System.out.print(prompt);
            if (pipe.hasNextDouble()) {
                rangeDouble = pipe.nextDouble();
                pipe.nextLine();

                if (rangeDouble >= low && rangeDouble <= high) {
                    done = true;
                } else {
                    System.out.println("Enter a valid number within the range, not: " + rangeDouble);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter a valid number within the range, not: " + trash);
            }
        } while (!done);
        return rangeDouble;
    }

    /**
     * @param pipe   - a Scanner opened to read from System.in
     * @param prompt - prompt for the user
     * @return - the end of sequence
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        System.out.print(prompt);
        String continueYN = pipe.nextLine();

        while (!continueYN.equalsIgnoreCase("y") && !continueYN.equalsIgnoreCase("n")) {

            System.out.println("\nInvalid response. Try again.");
            continueYN = pipe.next();
        }
        if (continueYN.equalsIgnoreCase("n")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @param pipe   - a Scanner opened to read from System.in
     * @param prompt - prompt for the user
     * @param regEx  - the pattern to match
     * @return - input that matches the pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean done = false;
        String trash = "";
        String retVal = "";

        do {

            System.out.print(prompt);
            retVal = pipe.nextLine();
            if (retVal.matches(regEx)) {
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter a matching pattern.");
            }
        } while (!done);
        return retVal;

    }

    /**
     * @param msg
     */
    public static void prettyHeader(String msg) {
        int whiteSpace;

        if (msg.length() < 54) {

            for (int x = 0; x <= 60; x++) {
                System.out.print("*");
            }
            System.out.print("\n");

            System.out.print("***");
            whiteSpace = (26 - (msg.length()) / 2);
            for (int x = 0; x <= whiteSpace; x++) {

                System.out.print(" ");
            }

            System.out.print(msg);

            whiteSpace = (27 - (msg.length()) / 2);
            for (int x = 0; x <= whiteSpace; x++) {

                System.out.print(" ");
            }
            System.out.println("***");

            for (int x = 0; x <= 60; x++) {
                System.out.print("*");
            }

        }
    }
}