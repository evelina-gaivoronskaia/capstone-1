package com.techelevator.ui;

import com.techelevator.Item;

import java.util.List;

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
}
