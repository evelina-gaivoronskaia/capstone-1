package com.techelevator.ui;

import com.techelevator.Item;
import com.techelevator.Money;

import java.math.BigDecimal;
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

        for (int i = 0; i < itemList.size(); i++) {
            System.out.printf("%-10s %-30s %s\n", itemList.get(i).getPlace(), itemList.get(i).getName(), itemList.get(i).getPrice());
            System.out.println();
        }
    }


    public static void purchaseItems(List<Item> itemList, Money currentMoney) {
        while(true){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Select Your Items");
        System.out.println("***************************************************");
        System.out.println();


        for (int i = 0; i < itemList.size(); i++) {
            System.out.printf("%-10s %-30s %-10s %s\n", itemList.get(i).getPlace(), itemList.get(i).getName(), itemList.get(i).getPrice(), itemList.get(i).getQuantity());
            System.out.println();
        }
        System.out.println();
        System.out.println("Current Money Provided: " + currentMoney.getCurrentMoney());

        System.out.println("Please select the item you would like to purchase using the item index (example: A1): ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().toLowerCase();

        for(int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getPlace().toLowerCase().equals(userInput) && itemList.get(i).getQuantity() > 0 && currentMoney.getCurrentMoney().subtract(itemList.get(i).getPrice()).compareTo(BigDecimal.ZERO) > 0) {
                currentMoney.setCurrentMoney(currentMoney.getCurrentMoney().subtract(itemList.get(i).getPrice()));
                itemList.get(i).setQuantity(itemList.get(i).getQuantity() - 1);
                itemList.get(i).getItemSaying();
            } else if (itemList.get(i).getQuantity() < 0){
                System.out.println("Item is NO LONGER AVAILABLE");
                break;
            } else if (currentMoney.getCurrentMoney().subtract(itemList.get(i).getPrice()).compareTo(BigDecimal.ZERO) < 0){
                System.out.println("Insufficient funds!");
                break;
            }
        }
        }

    }
}
