package com.techelevator;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;

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

    public BigDecimal feedMoney(Money currentMoney, Logger audit){
        System.out.print("Please feed in money. Only accept 1, 5, 10, and 20 dollar bills: ");
        Scanner userInput = new Scanner(System.in);
        String moneyString = userInput.nextLine();
        if(moneyString.equals("1") || moneyString.equals("5") || moneyString.equals("10") || moneyString.equals("20") ||
                moneyString.equals("1.00") || moneyString.equals("5.00") || moneyString.equals("10.00") || moneyString.equals("20.00")){
            this.currentMoney = this.currentMoney.add(new BigDecimal(moneyString));
            audit.write(LocalDateTime.now() + " | Money Fed: $" + moneyString + " | Current Money: $" + this.currentMoney);
            return this.currentMoney;

        } else {
            System.out.println("Invalid bill type!");
            return this.currentMoney;
        }
    }
    public String getChange(Money currentMoney, Logger audit){
        BigDecimal totalMoney = this.currentMoney;
        int dollarBills = totalMoney.intValue();
        totalMoney = totalMoney.subtract(new BigDecimal(dollarBills));

        int quater= 0 ;
        int dime= 0 ;
        int nickle = 0;
        while(totalMoney.compareTo(BigDecimal.ZERO) > 0){
            if(totalMoney.compareTo(new BigDecimal("0.25")) >= 0){
                quater++;
                totalMoney = totalMoney.subtract(new BigDecimal("0.25"));
            }else if(totalMoney.compareTo(new BigDecimal("0.10")) >= 0){
                dime++;
               totalMoney = totalMoney.subtract(new BigDecimal("0.10"));
            }else if (totalMoney.compareTo(new BigDecimal("0.05")) >= 0) {
                nickle++;
                totalMoney = totalMoney.subtract(new BigDecimal("0.05"));
            }
        }

        audit.write(LocalDateTime.now() + "| Change Given: $" + currentMoney.getCurrentMoney());
        this.currentMoney = new BigDecimal(0.00);
        return "Your change is: \nDollar Bills: " + dollarBills + "\nQuarters: " + quater +
                "\nDimes: " + dime + "\nNickles: " + nickle;
    }
}
