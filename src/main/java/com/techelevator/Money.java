package com.techelevator;

import java.math.BigDecimal;

public class Money {

    private BigDecimal currentMoney;
    private BigDecimal fedMoney;

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

    public static BigDecimal feedMoney(BigDecimal currentMoney, BigDecimal moneyFed){
        if(moneyFed.equals(1) || moneyFed.equals(5) || moneyFed.equals(10) || moneyFed.equals(20)){
            this.currentMoney = this.currentMoney.add(moneyFed);
            return this.currentMoney;
        } else {
            System.out.println("Invalid bill type!");
            return this.currentMoney;
        }
    }
}
