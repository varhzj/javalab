package com.varhzj.lab.designpattern.behavioral.chainofresponsibillity;

import java.util.Scanner;

/**
 * Created by varhzj on 10/19/16.
 */
public class ATMDispenseChain {

    private DispenseChain chain;

    public ATMDispenseChain() {
        chain = new Dollar50Dispenser()
                .setNextChain(new Dollar20Dispenser()
                        .setNextChain(new Dollar10Dispenser()));
    }

    public void dispense(Currency currency) {
        this.chain.dispense(currency);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenseChain = new ATMDispenseChain();

        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense:");
            Scanner scanner = new Scanner(System.in);
            amount = scanner.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            atmDispenseChain.dispense(new Currency(amount));
        }

    }

}
