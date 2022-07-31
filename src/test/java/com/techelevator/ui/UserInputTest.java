package com.techelevator.ui;

import com.techelevator.Money;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.plaf.basic.BasicCheckBoxUI;
import java.nio.charset.StandardCharsets;


import static org.junit.Assert.*;

public class UserInputTest {

    // We tried to implement the same way of testing for user input that Joshua showed us in the MoneyTests, but it didn't work.


//    UserInput object = new UserInput();
//
//    @Test
//    public void getHomeScreenOption_input_e_output_exit(){
//
//        String expected = "exit";
//
//        String userInput = "e";
//        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(inputStream);
//
//        String actual = object.getHomeScreenOption();
//        assertEquals(expected, actual);
//
//    }
//
//    @Test
//    public void getPurchaseScreenOption_input_f_output_finish(){
//        UserInput object = new UserInput();
//        Money money = new Money();
//        String expected = "finish";
//
//        String userInput = "f";
//        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(inputStream);
//
//        String actual = object.getPurchaseScreenOption(money);
//        assertEquals(expected, actual);
//    }
}