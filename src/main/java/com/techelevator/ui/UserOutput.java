package com.techelevator.ui;

import com.techelevator.Item;
import com.techelevator.Logger;
import com.techelevator.Money;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class UserOutput {
    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayItems(List<Item> itemList) {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Available Items");
        System.out.println("***************************************************");
        System.out.println();
        System.out.printf("%-10s %-30s %s\n", "Slot", "Item Name", "Price");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < itemList.size(); i++) {
            System.out.printf("%-10s %-30s %s\n", itemList.get(i).getPlace(), itemList.get(i).getName(), itemList.get(i).getPrice());
            System.out.println();
        }
    }


    public static void purchaseItems(List<Item> itemList, Money currentMoney, Logger audit) {
        while(true){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Select Your Items");
        System.out.println("***************************************************");
        System.out.println();
        System.out.printf("%-10s %-30s %-10s %s\n", "Slot", "Item Name", "Price", "Qty");
        System.out.println("------------------------------------------------------------");



        for (int i = 0; i < itemList.size(); i++) {
            System.out.printf("%-10s %-30s %-10s %s\n", itemList.get(i).getPlace(), itemList.get(i).getName(), itemList.get(i).getPrice(), itemList.get(i).getQuantity());
            System.out.println();
        }
        System.out.println();
        System.out.println("Current Money Provided: " + "$" + currentMoney.getCurrentMoney());

        System.out.print("Please select the item you would like to purchase using the item index or type E to Exit(example: A1): ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().toLowerCase();

        for(int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getPlace().toLowerCase().equals(userInput)) {
                if(itemList.get(i).getQuantity() > 0){
                    if (currentMoney.getCurrentMoney().subtract(itemList.get(i).getPrice()).compareTo(BigDecimal.ZERO) > 0){
                        currentMoney.setCurrentMoney(currentMoney.getCurrentMoney().subtract(itemList.get(i).getPrice()));
                        itemList.get(i).setQuantity(itemList.get(i).getQuantity() - 1);
                        System.out.println("Thank you for buying: " + itemList.get(i).getName() + " for "+ itemList.get(i).getPrice());
                        itemList.get(i).getItemSaying();
                        System.out.println("Remaining Money: $" + currentMoney.getCurrentMoney());
                        audit.write(LocalDateTime.now() + " | Item Bought: " + itemList.get(i).getPlace() + ") " + itemList.get(i).getName()
                                + " | Price: $" + itemList.get(i).getPrice() + " | Current Money: $" + currentMoney.getCurrentMoney());
                    } else{
                        System.out.println("Insufficient funds!");
                        break;
                    }
                }else {
                    System.out.println("Item is NO LONGER AVAILABLE");
                    break;

                }

            } else if(userInput.equals("e")){
                break;
            }
        }
        if(userInput.equals("e")){
            break;
        }
        }


    }
}
