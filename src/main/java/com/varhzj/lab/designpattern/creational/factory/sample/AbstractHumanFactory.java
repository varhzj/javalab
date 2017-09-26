package com.varhzj.lab.designpattern.creational.factory.sample;

/**
 * Created by varhzj on 8/10/17.
 */
public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> clazz);

}
