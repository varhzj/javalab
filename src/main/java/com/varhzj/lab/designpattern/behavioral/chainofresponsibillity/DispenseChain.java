package com.varhzj.lab.designpattern.behavioral.chainofresponsibillity;

/**
 * Created by varhzj on 10/19/16.
 */
public interface DispenseChain {

    DispenseChain setNextChain(DispenseChain nextChain);

    void dispense(Currency currency);

}
