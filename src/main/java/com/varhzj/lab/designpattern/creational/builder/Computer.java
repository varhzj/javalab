package com.varhzj.lab.designpattern.creational.builder;

/**
 * Created by varhzj on 16-10-16.
 */
public class Computer {

    // required parameters
    private String cpu;
    private String ram;
    private String hdd;

    // optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "CPU = " + this.cpu
                + "; RAM = " + this.ram
                + "; HDD = " + this.hdd
                + "; isGraphicsCardEnabled = " + this.isGraphicsCardEnabled
                + "; isBluetoothEnabled = " + this.isBluetoothEnabled;
    }

    public static class ComputerBuilder {
        // required parameters
        private String cpu;
        private String ram;
        private String hdd;

        // optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String cpu, String ram, String hdd) {
            this.cpu = cpu;
            this.ram = ram;
            this.hdd = hdd;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }

    }

    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("2.9 GHz", "8 GB", "1 TB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(false)
                .build();
        System.out.println(computer);
    }
}
