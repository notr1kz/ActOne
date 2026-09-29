/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actone;

/**
 *
 * @author Administrator
 */
import java.util.Arrays;
import java.util.Scanner;

public class WordBank {
 public static int binarySearch(String[] arr, String target) {
        int low = 0;
        int high = arr.length - 1;
 
        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = arr[mid].compareToIgnoreCase(target);
 
            if (comparison == 0) {
                return mid; // found at index mid
            } else if (comparison < 0) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }
        return -1; // not found
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // Ask the user to enter the number of words
        System.out.print("Enter the number of words: ");
        int n = Integer.parseInt(scanner.nextLine().trim());
 
        String[] words = new String[n];
 
        // Allow the user to enter each word
        for (int i = 0; i < n; i++) {
            String entry;
            while (true) {
                System.out.print("Enter word " + (i + 1) + ": ");
                entry = scanner.nextLine().trim();
 
                // Reject empty input or input containing whitespace (more than one word)
                if (entry.isEmpty()) {
                    System.out.println("Input cannot be empty. Please try again.");
                } else if (entry.contains(" ") || entry.matches(".*\\s.*")) {
                    System.out.println("Please enter only one word.");
                } else {
                    break;
                }
            }
            words[i] = entry;
        }
 
        // Display the original list of words
        System.out.println("\nOriginal list of words:");
        System.out.println(Arrays.toString(words));
 
        // Sort the words alphabetically
        String[] sortedWords = Arrays.copyOf(words, words.length);
        Arrays.sort(sortedWords, String.CASE_INSENSITIVE_ORDER);
 
        // Display the sorted list
        System.out.println("\nSorted list of words:");
        System.out.println(Arrays.toString(sortedWords));
 
        // Ask the user to enter a word to search for
        System.out.print("\nEnter a word to search for: ");
        String target = scanner.nextLine().trim();
 
        // Use Binary Search to find the word
        int index = binarySearch(sortedWords, target);
 
        // Display whether the word was found or not
        if (index != -1) {
            System.out.println("\"" + target + "\" was found in the word bank.");
            System.out.println("Position in the sorted list: " + (index + 1));
        } else {
            System.out.println("\"" + target + "\" was not found in the word bank.");
        }
 
        scanner.close();
    }    
}
