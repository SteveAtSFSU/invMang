/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author sstev
 */
public class InventoryManager {

    //method to display opening message.
    public static void openingMsg() {
        System.out.println("Welcome to SFSU's Book Store Invetory Manager.");
        System.out.println("Please select an option.");
        System.out.println("PrintInventory (p)\n"
                + "Check Low inventory (c)\n"
                + "Print Total Value of inventory (v)\n"
                + "Exit (e)");

    }

    //method to print inventory.
    public static void printInventory(Item[] Item) {
        String header;
        header = String.format("%-15s %-10s %-10s", "Name", "Quantity", "Price Per Unit");
        System.out.println(header);
        for (int i = 0; Item.length > i; i++) {
            System.out.println(Item[i]);
        }
    }

    //method to check if any item of the inventory is low.
    public static void checkLowInventory(Item[] Item) {
       int cnt = 0;
       
        for (int i = 0; i < Item.length; i++) {
            
            if (Item[i].getQuantity() <= 5) {
                System.out.println(Item[i].toString());
                cnt++;
            }
            

        }
        
        if(cnt == 0){
            System.out.println("All items are not low.");
        }
    }

    //method to check total price of inventory items.
    public static double totalInventoryValue(Item[] Item) {
        double total = 0;

        for (int i = 0; i < Item.length; i++) {
            total += (Item[i].getQuantity() * Item[i].getPrice());

        }
        System.out.println("Total inventory value: " + total);
        return total;
    }

    public static void main(String[] args) {
        
        //read in the text file
        File itemS = new File("items.txt");

        //create variables to store the info.
        String name = null;
        int quantity = 0;
        double ppu = 0;
        int i = 0;

        //create item array
        Item[] items;
        items = new Item[10];

        //try block for reading in file so that if there is an error it will be caught. 
        try {
            Scanner input = new Scanner(itemS);
            while (input.hasNext() && i < items.length) {
                name = input.next();
                quantity = input.nextInt();
                ppu = input.nextDouble();

                // for every item in the array create a new item object.
                items[i] = new Item(name, quantity, ppu);
                i++;
            }

        } catch (FileNotFoundException ex) {

        }
        
        //create scanner variable for keyboard input.
        Scanner inputChoice = new Scanner(System.in);
  
        //create variables for condition and input.
        char choice = 'a';
        boolean condition = false;
        openingMsg();
        
        //while loop for running the switch while user doesn't want to exit.
        while(condition != true){
            
            choice = inputChoice.next().charAt(0);
            System.out.print("\n");
    
            switch (choice){
                case 'p': printInventory(items);
                          System.out.print("\n");
                          openingMsg();
                          break;
                case 'c': checkLowInventory(items);
                          System.out.print("\n");
                          openingMsg();
                          break;
                case 'v': totalInventoryValue(items);
                          System.out.print("\n");
                          openingMsg();
                          break;
                case 'e': condition = true;
                          break;
                
                default: System.out.println("Please enter a valid choice.");
                         System.out.print("\n");
                         openingMsg();
                         break;
                         
            }
    
    }
        

    }

}
