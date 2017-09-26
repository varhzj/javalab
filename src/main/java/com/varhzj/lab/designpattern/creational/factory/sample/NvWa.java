package com.varhzj.lab.designpattern.creational.factory.sample;

/**
 * Created by varhzj on 8/10/17.
 * 工厂方法场景类
 */
public class NvWa {

    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = new HumanFactory();

        BlackHuman blackHuman = humanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();

        WhiteHuman whiteHuman = humanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();

        YellowHuman yellowHuman = humanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();

        // error
//        Human human = humanFactory.createHuman(Human.class);
//        human.getColor();

    }

}
