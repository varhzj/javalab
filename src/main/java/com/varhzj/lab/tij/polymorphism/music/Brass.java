package com.varhzj.lab.tij.polymorphism.music;

public class Brass extends Instrument {

    @Override
    public void play(Note note) {
        System.out.println("Brass.play() " + note);
    }
}

