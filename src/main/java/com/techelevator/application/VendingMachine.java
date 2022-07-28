package com.techelevator.application;

import com.techelevator.Item;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    static Scanner fileScanner;
    public void run() {
        File fileName = new File("catering.csv");
        List<Item> itemList = new ArrayList<>();
        readFile(fileName, itemList);
        for (int i = 0; i < itemList.size(); i++) {
            if (i == 1){
                Item currentItem = itemList.get(i);
                currentItem.setQuantity();
            }
            System.out.println(itemList.get(i));

        }
        while(true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if(choice.equals("display")) {
                // display the items
            }
            else if(choice.equals("purchase")) {
                // make a purchase
            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    public List<Item> readFile(File fileName, List<Item> itemList){
        try {
            fileScanner = new Scanner(fileName);
            String[] strArray = new String[4];
            while(fileScanner.hasNextLine()){
                String str = fileScanner.nextLine();
                strArray = str.split(",");
                //int priceconvert = Integer.parseInt(strArray[2]);
                BigDecimal price = new BigDecimal(strArray[2]);
                String name = str.substring(0, 2);
                itemList.add(new Item(strArray[1], strArray[0], price, strArray[3]));
            }
            return itemList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemList;

    }
}
