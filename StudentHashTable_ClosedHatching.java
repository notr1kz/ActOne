/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studenthashtable_closedhatching;

/**
 *
 * @author Administrator
 */

    //De Guzman, Pharrell Calvin L.
    //COM252
    //CCDATRCL
    //Closed Hatching
import java.util.Scanner;
import studenthashtable_closedhatching.StudentHashTable_ClosedHatching.StudentHashTable_ClosedHatching.Product;

public class StudentHashTable_ClosedHatching {
    
    static class Product {
    int id;
    String name;
    
    Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
    }
}

static class HashTable {
    private final Product[] table;
    private final boolean[] deleted;
    private final int tableSize;
    private int count;
    
    HashTable(int tableSize) {
        this.tableSize = tableSize;
        this.table = new Product[tableSize];
        this.deleted = new boolean[tableSize];
        this.count = 0;
    }
    
    private int hash(int id) {
        return id % tableSize;
    }
    
    boolean isFull() {
        return count == tableSize;
    }
    void insert(int id, String name) {
        if(isFull()) {
            System.out.println("Hash Table is full. Insertion was not succeeded.");
            return;
        }
        
        int index = hash(id);
        int startIndex = index;
        int probes = 0;
        
        while (table[index] != null && !deleted[index]) {
            if (table[index].id == id) {
                System.out.println("Product is Same. Insertion did not succeed.");
                return;
            }
            probes++;
            index = (startIndex + probes) % tableSize;
            if (index == startIndex) {
                System.out.println("Hash Table is full. Insertion failed.");
                return;
            }
        }
        
        table[index] = new Product(id, name);
        deleted[index] = false;
        count++;
        System.out.println("Product inserted at index: " + index);
    }
    
    Product search(int id) {
        int index = hash(id);
        int startIndex = index;
        int probes = 0;
        
        while(table[index] != null) {
            if(!deleted[index] && table[index].id == id) {
                return table[index];
            }
            probes++;
            index = (startIndex + probes) % tableSize;
            if (index == startIndex) break;
        }
        return null;
    }
    
    boolean remove(int id) {
        int index = hash(id);
        int startIndex = index;
        int probes = 0;
        
        while (table[index] != null) {
            if(!deleted[index] && table[index].id == id) {
                deleted[index] = true;
                count--;
                return true;
            }
            probes++;
            index = (startIndex + probes) % tableSize;
            if(index == startIndex) break;
        }
        return false;
    }
    
    void display() {
        System.out.println("==== HASH TABLE ====");
        for (int i = 0; i < tableSize; i++) {
           if(table[i] != null && !deleted[i]) {
               System.out.println("Index: " + i + " : " + table[i].id + " - " + table[i].name);
           } else {
               System.out.println("Index " + i + " : Empty");
           }
        }
    }
}

    // MENU INTERFACE!! HASHTAGgrrmondays
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      System.out.print("Enter Hash Table size: ");
      int tableSize = Integer.parseInt(scan.nextLine().trim());
      HashTable hashtable = new HashTable(tableSize);
      
      System.out.print("Enter number of Students: ");
      int numProducts = Integer.parseInt(scan.nextLine().trim());
      
      for (int i = 0; i < numProducts; i++) {
          System.out.println();
          System.out.println("Students: " + (i + 1));
          System.out.print("Enter Student ID: ");
          int id = Integer.parseInt(scan.nextLine().trim());
          System.out.print("Enter Student Name: ");
          String name = scan.nextLine().trim();
          hashtable.insert(id, name);
        }
      
      boolean running = true;
      while(running) {
          System.out.println();
          System.out.println("==== Welcome to the MENU ====");
          System.out.println("1. Insert Student");
          System.out.println("2. Search Student");
          System.out.println("3. Remove Student");
          System.out.println("4. View Hash Table");
          System.out.println("5. Exit");
          System.out.print("Enter Choice: ");
          
          String choice = scan.nextLine().trim();
          switch(choice) {
              case "1":
                System.out.print("Enter Student ID: ");
                int insertId = Integer.parseInt(scan.nextLine().trim());
                System.out.print("Enter Student Name: ");
                String insertName = scan.nextLine().trim();
                hashtable.insert(insertId, insertName);
                break;
                
              case "2":
                  System.out.print("Enter Student ID to search: ");
                    int searchId = Integer.parseInt(scan.nextLine().trim());
                    Product found = hashtable.search(searchId);
                    if (found != null) {
                        System.out.println("Found: " + found.id + " - " + found.name);
                    } else {
                        System.out.println("Student ID not found.");
                    }
                    break;
                    
              case "3":
                   System.out.print("Enter Student ID to remove: ");
                    int removeId = Integer.parseInt(scan.nextLine().trim());
                    if (hashtable.remove(removeId)) {
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Student ID not found.");
                    }
                    break;
                
              case "4":
                  hashtable.display();
                  break;
                  
              case "5":
                  running = false;
                  System.out.println("Thank you for using HashTable. Exiting now...");
                  break;
                  
              default:
                  System.out.println("Invalid choice");
                  
          }
      }
      scan.close();
    }    

