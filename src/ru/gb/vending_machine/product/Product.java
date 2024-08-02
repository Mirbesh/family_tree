package ru.gb.vending_machine.product;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "Наименование '" + name + '\'' +
                ", цена=" + price + " cом.";
    }
}
