package com.varhzj.lab.designpattern.behavioral.visitor;

/**
 * Created by varhzj on 10/19/16.
 */
public class ShoppingCartClient {

    public static void main(String[] args) {
        ItemElement[] itemElements = new ItemElement[] {
                new Book(75, "8882328"),
                new Fruit(5, 6, "Apple")
        };
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement itemElement : itemElements) {
            sum += itemElement.accept(visitor);
        }
        System.out.println("Total cost " + sum);
    }

}
