package com.techelevator;

import org.junit.Test;

import javax.swing.plaf.basic.BasicCheckBoxUI;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class MoneyTest {

        @Test
        public void feedMoney_put_in_5_get_5(){
            Money money = new Money();
            Logger testLogger = new Logger("auditTest.txt");

            BigDecimal expected = new BigDecimal(5);
            String userInput = "5";
            InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(inputStream);

            BigDecimal actual = money.feedMoney(money, testLogger);
            assertEquals(expected, actual);
        }

    @Test
    public void feedMoney_put_in_3_get_currentMoney(){
        Money money = new Money();
        Logger testLogger = new Logger("auditTest.txt");

        BigDecimal expected = new BigDecimal(0);
        String userInput = "3";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        BigDecimal actual = money.feedMoney(money, testLogger);
        assertEquals(expected, actual);
    }

    @Test
    public void feedMoney_put_in_money_get_currentMoney(){
        Money money = new Money();
        Logger testLogger = new Logger("auditTest.txt");

        BigDecimal expected = money.getCurrentMoney();
        String userInput = "money";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        BigDecimal actual = money.feedMoney(money, testLogger);
        assertEquals(expected, actual);
    }


    @Test
    public void getChange_put_in_thrity_cents_get_quarter_and_nickel(){
        Money money = new Money();
        Logger logger = new Logger("auditTest.txt");
        money.setCurrentMoney(new BigDecimal("0.30"));

        String expected = "Your change is: \nDollar Bills: " + 0 + "\nQuarters: " + 1 +
                "\nDimes: " + 0 + "\nNickles: " + 1;

        String actual = money.getChange(money, logger);
        assertEquals(expected, actual);
    }

    @Test
    public void getChange_put_in_two_dollars_sixty_five_cents_get_two_dollars_two_quarter_and_dime_and_nickel(){
        Money money = new Money();
        Logger logger = new Logger("auditTest.txt");
        money.setCurrentMoney(new BigDecimal("2.65"));

        String expected = "Your change is: \nDollar Bills: " + 2 + "\nQuarters: " + 2 +
                "\nDimes: " + 1 + "\nNickles: " + 1;

        String actual = money.getChange(money, logger);
        assertEquals(expected, actual);
    }
}