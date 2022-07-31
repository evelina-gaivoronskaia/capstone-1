package com.techelevator.application;

import com.techelevator.Item;
import com.techelevator.Logger;
import com.techelevator.Money;
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
        Money money = new Money();
        File fileName = new File("vending.csv");
        List<Item> itemList = new ArrayList<>();
        readFile(fileName, itemList);
        BigDecimal currentMoney = new BigDecimal(0.00);
        BigDecimal moneyFed = new BigDecimal(0.00);
        Logger audit = new Logger("Audit.txt");
        while(true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if(choice.equals("display")) {
                UserOutput.displayItems(itemList);
            }
            else if(choice.equals("purchase")) {
                while(true) {
                    String purchaseChoice = UserInput.getPurchaseScreenOption(money);
                    if (purchaseChoice.equals("money")) {
                        currentMoney = money.feedMoney(money, audit);
                    }else if(purchaseChoice.equals("select")){
                        UserOutput.purchaseItems(itemList, money, audit);
                    }else if (purchaseChoice.equals("finish")){
                        break;

                    }else {
                        System.out.println("Not a choice.");
                    }
                }
            }
            else if(choice.equals("exit")) {

                System.out.println(money.getChange(money, audit));
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
