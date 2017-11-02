package com.varhzj.lab.tij.polymorphism.music;

public class Wind extends Instrument {

    @Override
    public void play(Note note) {
        System.out.println("Wind.play() " + note);
    }
}
