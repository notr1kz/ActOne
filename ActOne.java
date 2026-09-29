/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actone;

/**
 *
 * @author Administrator
 */
import java.util.Scanner;
public class ActOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] numbers = inputArray(sc, size);

        // Count positives and negatives first so we can size arrays 2 and 3
        int posCount = 0, negCount = 0;
        for (int num : numbers) {
            if (num >= 0) posCount++;
            else negCount++;
        }

        int[] positives = new int[posCount];
        int[] negatives = new int[negCount];
        separateNumbers(numbers, positives, negatives);

        System.out.println("\nOriginal array:");
        displayArray(numbers);

        System.out.println("\nPositive numbers (2nd array):");
        displayArray(positives);

        System.out.println("\nNegative numbers (3rd array):");
        displayArray(negatives);

        int sum = computeSum(positives);
        double average = computeAverage(negatives);

        System.out.println("\nSum of positive numbers: " + sum);
        System.out.println("Average of negative numbers: " + average);
    }

    // Function to input array elements
    public static int[] inputArray(Scanner sc, int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    // Function to separate positives and negatives into their own arrays
    public static void separateNumbers(int[] original, int[] positives, int[] negatives) {
        int posIndex = 0, negIndex = 0;
        for (int num : original) {
            if (num >= 0) {
                positives[posIndex] = num;
                posIndex++;
            } else {
                negatives[negIndex] = num;
                negIndex++;
            }
        }
    }

    // Function to display an array
    public static void displayArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("(empty)");
            return;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Function to compute sum
    public static int computeSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Function to compute average
    public static double computeAverage(int[] arr) {
        if (arr.length == 0) return 0;
        return (double) computeSum(arr) / arr.length;
    }
}
    
    

