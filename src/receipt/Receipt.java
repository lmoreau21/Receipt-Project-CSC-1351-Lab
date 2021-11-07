package receipt;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Receipt {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        String fileName = "reciept_"+(rand.nextInt(900)+100);
        PrintWriter outFile = new PrintWriter(fileName+".txt");
        char anotherItem = 'y';
        double totalPrice = 0.0;
        
        //date
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd - hh:mm:ss a");
        String currentDateTimeFormatted = currentDateTime.format(formatter);
        
        //header for text file
        outFile.println("========================================");
        outFile.println("\t  Welcome to LSUMart");
        outFile.println("========================================");
        outFile.printf("%-10s%-10s%-10s%-10s\n","Item","Quantity","Price","Total");
        outFile.println("----------------------------------------");
        while(anotherItem == 'y' && anotherItem != 'Y'){
            Item itemName = new Item();
            itemName.setVariables();
            itemName.getInfo(outFile);
            totalPrice += itemName.getTotalPrice();
            
            System.out.println("Press 'y' to enter another item.");
            anotherItem = in.next().charAt(0);
        }
        //more formating for the bottom of the file
        outFile.println("----------------------------------------");
        outFile.printf("%30s$%-10.2f","Total: ",totalPrice);
        outFile.printf("\n%30s$%-10.2f","Tax: ",totalPrice*.09);
        outFile.printf("\n%30s$%-10.2f","Total after Tax: ",totalPrice*1.09);
        outFile.println("\n========================================");
        
        System.out.println(fileName+" has been issued on "+currentDateTimeFormatted+".");
        in.close();
        outFile.close();
    }
    
}
