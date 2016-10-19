package com.varhzj.lab.designpattern.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varhzj on 10/19/16.
 */
public class ShoppingCart {

    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotal() {
        double sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(calculateTotal());
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1001", 2.8);
        Item item2 = new Item("1002", 5);

        cart.addItem(item1);
        cart.addItem(item2);

        // pay with paypal
        cart.pay(new PaypalStrategy("xxxxx@xxx.com", "*******"));

        // pay with credit card
        cart.pay(new CreditCardStrategy("xxx", "1213213123", "233", "10/11"));
    }

}
