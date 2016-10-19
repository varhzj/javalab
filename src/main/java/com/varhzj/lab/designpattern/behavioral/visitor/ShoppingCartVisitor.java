package com.varhzj.lab.designpattern.behavioral.visitor;

/**
 * Created by varhzj on 10/19/16.
 */
public interface ShoppingCartVisitor {

    int visit(Book book);

    int visit(Fruit fruit);

}
