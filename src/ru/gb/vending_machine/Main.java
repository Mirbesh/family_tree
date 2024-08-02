package ru.gb.vending_machine;

import ru.gb.vending_machine.product.Bottle;
import ru.gb.vending_machine.product.Product;
import ru.gb.vending_machine.vending.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Product product1 = new Product("Lays", 90);
        Product product2 = new Bottle("Coca-Cola", 120, 2);
        Product product3 = new Product("Mars", 60);

        vendingMachine.addProducts(product1);
        vendingMachine.addProducts(product2);
        vendingMachine.addProducts(product3);

        System.out.println(vendingMachine);

    }
}