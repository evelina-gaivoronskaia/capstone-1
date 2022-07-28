package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Money {

    private BigDecimal currentMoney;
    private BigDecimal fedMoney;

    public Money(){
        this.currentMoney = new BigDecimal(0.00);
        this.fedMoney = new BigDecimal(0.00);
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(BigDecimal currentMoney) {
        this.currentMoney = currentMoney;
    }

    public BigDecimal getFedMoney() {
        return fedMoney;
    }

    public void setFedMoney(BigDecimal fedMoney) {
        this.fedMoney = fedMoney;
    }

    public BigDecimal feedMoney(BigDecimal currentMoney){
        System.out.print("Please feed in money. Only accept 1, 5, 10, and 20 dollar bills: ");
        Scanner userInput = new Scanner(System.in);
        String moneyString = userInput.nextLine();
        if(moneyString.equals("1") || moneyString.equals("5") || moneyString.equals("10") || moneyString.equals("20")){
            BigDecimal moneyFed = new BigDecimal(moneyString);
            this.currentMoney = this.currentMoney.add(moneyFed);
            return this.currentMoney;
        } else {
            System.out.println("Invalid bill type!");
            return this.currentMoney;
        }
    }
}
