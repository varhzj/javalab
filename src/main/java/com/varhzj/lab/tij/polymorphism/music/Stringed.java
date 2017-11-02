package com.varhzj.lab.tij.polymorphism.music;

public class Stringed extends Instrument {

    @Override
    public void play(Note note) {
        System.out.println("Stringed.play() " + note);
    }
}

