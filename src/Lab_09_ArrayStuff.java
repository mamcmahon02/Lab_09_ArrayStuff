import java.util.Random;
import java.util.Scanner;

public class Lab_09_ArrayStuff {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] dataPoints = new int[100];
        Scanner in = new Scanner(System.in);

        int val = rnd.nextInt(100) + 1;  // gives a value from 1 to 100
        int index = rnd.nextInt(dataPoints.length);

        int sum = 0;
        double average = 0;
        int targetVal;
        int targetCnt = 0;
        boolean found = false;

        for (int e = 0; e < dataPoints.length; e++)
        {
            dataPoints[e] = rnd.nextInt(100) + 1;
        }
        for (int e : dataPoints)
        {
            System.out.printf("%3d |", e);
        }

        for (int e : dataPoints)
        {
            sum += e;
        }
        average = (double) sum / dataPoints.length;

        System.out.println("\n The sum of the data points is: " + sum + "\n the average of the data points is: " + average);

        targetVal = SafeInput.getRangedInt(in, "Please enter the value you wish to find: ", 1, 100);

        for (int e = 0; e < dataPoints.length; e++)
        {
            if (dataPoints[e] == targetVal) {
                targetCnt++;
                found = true;
            }
        }
        System.out.println("Your target value was found " + targetCnt + " times in the array");

        for(int e= 0; e < dataPoints.length; e++)
        {

            if (dataPoints[e] == targetVal)
            {
                System.out.println("\n Your target value was found at location " + e + " in the index");
                found = true;
                break;
            }
        }

        int max = dataPoints[0];
        int min = dataPoints[99];

        for(int e:dataPoints)
        {
            if(e > max ) // Found a new max value
            {
                max = e;
            }
            if (e < min ) // Found a new min value
            {
                min = e;
            }
        }
        System.out.printf("\n The min max is %4d %4d", min, max);

        System.out.println("\n Average of dataPoints is: " + getAverage(dataPoints));

    }
    public static double getAverage(int values[])
    {
        int sum = 0;
        double average = 0;


        for (int i : values)
        {
            sum += i;
        }
        average = (double) sum / values.length;
        return average;

    }

}