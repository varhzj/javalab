package com.varhzj.lab.java8.stream;

/**
 * Created by varhzj on 10/28/16.
 */
public class Transaction {

    public static final Transaction NULL_TRANSACTION = new Transaction(Trader.NULL_TRADER, -1, -1);

    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
