package receipt;

import java.util.Scanner;
import java.io.PrintWriter;

public class Item {
    private String name;
    private int quantity;
    private double price;
    private double totalPrice;
    
    Scanner in = new Scanner(System.in);
   
    public void setVariables(){
        System.out.print("Item: ");
        name = in.next();
       
        System.out.print("Quantity: ");
        quantity = in.nextInt();
   
        System.out.print("Price: $");
        price = in.nextDouble();
        
        totalPrice = price*quantity;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    public double getTotalPrice(){
        return totalPrice;
    } 
    public void getInfo(PrintWriter outFile){
        outFile.printf("%-10s%-10d$%,-9.2f$%,-10.2f\n",name,quantity,price,totalPrice);
    }
}
