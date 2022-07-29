package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private String name;
    private String place;
    private int quantity;
    private BigDecimal price;
    private String type;

    public Item(String name, String place, BigDecimal price, String type) {
        this.name = name;
        this.place = place;
        this.price = price;
        this.type = type;
        this.quantity = 6;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }


    public void getItemSaying(){
        if (this.type.equals("Munchy")){
            System.out.println( "Munchy, Munchy, so Good!");
        } else if (this.type.equals("Candy")){
            System.out.println("Sugar, Sugar, so Sweet!");
        } else if(this.type.equals("Gum")){
            System.out.println("Chewy, Chewy, Lots O Bubbles!");
        }else if(this.type.equals("Drink")){
            System.out.println("Drinky, Drinky, Slurp Slurp!");
        }
    }


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
