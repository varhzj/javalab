package com.varhzj.lab.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by varhzj on 10/28/16.
 */
public class TransactionSample {

    private static List<Transaction> transactions;

    static {
        Trader java = new Trader("Java", "Beijing");
        Trader ruby = new Trader("Ruby", "Nanjing");
        Trader python = new Trader("Python", "Shanghai");
        Trader go = new Trader("Go", "Beijing");
        Trader js = new Trader("JavaScript", "Shanghai");

        transactions = Arrays.asList(
                new Transaction(java, 2015, 1000),
                new Transaction(java, 2013, 720),
                new Transaction(ruby, 2013, 500),
                new Transaction(ruby, 2011, 660),
                new Transaction(go, 2011, 120),
                new Transaction(js, 2015, 1200),
                new Transaction(python, 2014, 440)
        );
    }

    private static void transactionsIn2013() {
        List<Transaction> transactionsIn2013 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2013)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("transactionsIn2013: " + transactionsIn2013);
    }

    private static void traderCities() {
        List<String> traderCities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("traderCities: " + traderCities);

        Set<String> traderCitySets = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println("traderCitySets: " + traderCitySets);
    }

    private static void tradersFromBeijing() {
        List<Trader> tradersFromBeijing = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Beijing".equals(trader.getCity()))
                .distinct() // don't forget this
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("tradersFromBeijing: " + tradersFromBeijing);
    }

    private static void allTradersNameCharacters() {
        List<String> allTradersNameCharacters = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .map(name -> name.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("allTradersNameCharacters: " + allTradersNameCharacters);
    }

    private static void joinTradersName() {
        String allNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println("joinTradersName: " + allNames);
    }

    private static void anyTraderFromNanjing() {
        boolean anyTraderFromNanjing = transactions.stream()
                .anyMatch(transaction -> "Nanjing".equals(transaction.getTrader().getCity()));
        System.out.println("anyTraderFromNanjing: " + anyTraderFromNanjing);
    }

    private static void totalTransValueFromBeijingTrader() {
        long total = transactions.stream()
                .filter(transaction -> "Beijing".equals(transaction.getTrader().getCity()))
                .mapToInt(Transaction::getValue)
//                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println("totalTransValueFromBeijingTrader: " + total);
    }

    private static void printTransValuesFromShanghaiTrader() {
        System.out.println("Transaction values from Shanghai Traders: ");
        transactions.stream()
                .filter(transaction -> "Shanghai".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    private static void maxTransactionValue() {
        Optional<Integer> maxValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("maxTransactionValue: " + maxValue.orElse(-1));
    }

    private static void minTransaction() {
        Optional<Transaction> minTransaction = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue));
        System.out.println("minTransaction: " + minTransaction.orElse(Transaction.NULL_TRANSACTION));
    }

    public static void main(String[] args) {
        transactionsIn2013();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        traderCities();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        tradersFromBeijing();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        allTradersNameCharacters();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        joinTradersName();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        anyTraderFromNanjing();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        totalTransValueFromBeijingTrader();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        printTransValuesFromShanghaiTrader();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        maxTransactionValue();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        minTransaction();
    }

}
