package com.varhzj.lab.interview.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    public static void hanoi(int n, String from, String mid, String to) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, to, mid);
        System.out.println(from + "--->" + to);
        hanoi(n - 1, mid, from, to);
    }

    public static void hanoiOrder(int n, String from, String mid, String to) {
        if (n == 0) {
            return;
        }
        hanoiOrder(n - 1, from, mid, to);
        System.out.println(from + "--->" + mid);
        hanoiOrder(n - 1, to, mid, from);
        System.out.println(mid + "--->" + to);
        hanoiOrder(n - 1, from, mid, to);
    }

    public static void printPair(int num) {
        doPrintPair(num, num, new char[num * 2], 0);
    }

    private static void doPrintPair(int l, int r, char[] str, int index) {
        if (l < 0 || l > r) {
            return;
        }

        if (l == 0 && r == 0) {
            System.out.println(str);
            return;
        }

        if (l > 0) {
            str[index] = '(';
            doPrintPair(l - 1, r, str, index + 1);
        }
        if (l < r) {
            str[index] = ')';
            doPrintPair(l, r - 1, str, index + 1);
        }

    }

    public static void eightQueens() {
        printEightQueens(new int[8], 0);
    }

    private static void printEightQueens(int[] queens, int row) {
        if (row == 8) {
            System.out.println(
                    Arrays.stream(queens)
                            .mapToObj(Integer::toString)
                            .collect(Collectors.joining(","))
            );
            return;
        }

        for (int i = 0; i < 8; i++) {
            queens[row] = i;
            if (isValid(queens, row)) {
                printEightQueens(queens, row + 1);
            }
        }
    }

    private static boolean isValid(int[] queens, int row) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(queens[i] - queens[row]);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        hanoiOrder(3, "A", "B", "C");
//        printPair(4);
        eightQueens();
    }

}
