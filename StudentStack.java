/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actone;

/**
 *
 * @author Administrator
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.EmptyStackException;

    public class StudentStack {
     // The stack that stores student names
    private Stack<String> stack = new Stack<>();
    private Scanner scanner = new Scanner(System.in);
 
    // 1. Push 5 student names into the stack (from user input)
    public void pushNames() {
        System.out.println("\n--- Enter 5 Student Names ---");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter name of student " + i + ": ");
            String name = scanner.nextLine();
            stack.push(name);
        }
        System.out.println("All 5 names have been pushed into the stack.");
    }
 
    // 2. Display all names in the stack
    public void displayAll() {
        System.out.println("\n--- Current Stack (top to bottom) ---");
        if (stack.isEmpty()) {
            System.out.println("The stack is empty.");
            return;
        }
        // Iterate without modifying the stack
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println((stack.size() - i) + ". " + stack.get(i));
        }
    }
 
    // 3. Pop one student name
    public void popName() {
        System.out.println("\n--- Popping a Student ---");
        try {
            String removed = stack.pop();
            System.out.println("Removed student: " + removed);
        } catch (EmptyStackException e) {
            System.out.println("Cannot pop. The stack is already empty.");
        }
    }
 
    // 4. Show the student name currently at the top using peek()
    public void peekTop() {
        System.out.println("\n--- Top of Stack ---");
        try {
            String top = stack.peek();
            System.out.println("Student currently at the top: " + top);
        } catch (EmptyStackException e) {
            System.out.println("The stack is empty. No top element.");
        }
    }
 
    // 5. Check if the stack is empty
    public void checkEmpty() {
        System.out.println("\n--- Empty Check ---");
        if (stack.isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            System.out.println("The stack is NOT empty.");
        }
    }
 
    // 6. Check if the stack is full (using a fixed capacity of 5)
    public void checkFull() {
        final int CAPACITY = 5;
        System.out.println("\n--- Full Check (capacity = " + CAPACITY + ") ---");
        if (stack.size() >= CAPACITY) {
            System.out.println("The stack is full.");
        } else {
            System.out.println("The stack is NOT full. (" + stack.size() + "/" + CAPACITY + ")");
        }
    }
 
    // Menu-driven main program
    public void run() {
        int choice;
        do {
            System.out.println("\n===== STUDENT NAME STACK MENU =====");
            System.out.println("1. Push 5 student names into the stack");
            System.out.println("2. Display all names in the stack");
            System.out.println("3. Pop one student name");
            System.out.println("4. Display the remaining names");
            System.out.println("5. Show the student at the top (peek)");
            System.out.println("6. Check if the stack is empty");
            System.out.println("7. Check if the stack is full");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
 
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-8): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline
 
            switch (choice) {
                case 1:
                    pushNames();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    popName();
                    break;
                case 4:
                    displayAll(); // "Display the remaining names" reuses displayAll()
                    break;
                case 5:
                    peekTop();
                    break;
                case 6:
                    checkEmpty();
                    break;
                case 7:
                    checkFull();
                    break;
                case 8:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-8.");
            }
        } while (choice != 8);
 
        scanner.close();
    }
 
    public static void main(String[] args) {
        StudentStack app = new StudentStack();
        app.run();
    }
}

