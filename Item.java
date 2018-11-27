/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanager;

/**
 *
 * @author sstev
 */
public class Item {
    
    private String name;
    private int quantity;
    private double price;
    
    Item(){
        
    }
    
    Item(String name, int quantity, double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    @Override
    public String toString(){
        return String.format("%-15s %-10s %-10s",this.name , this.quantity , this.price);
    }
    
}
