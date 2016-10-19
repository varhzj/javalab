package com.varhzj.lab.designpattern.behavioral.chainofresponsibillity;

/**
 * Created by varhzj on 10/19/16.
 */
public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain nextChain;

    @Override
    public DispenseChain setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
        return this;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 50) {
            int num = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing " + num + " 50$ note.");
            if (remainder != 0) {
                this.nextChain.dispense(new Currency(remainder));
            }
        }
        else {
            this.nextChain.dispense(currency);
        }
    }
}
