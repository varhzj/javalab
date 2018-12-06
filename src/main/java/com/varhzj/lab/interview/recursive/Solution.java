package com.varhzj.lab.interview.recursive;

public class Solution {

    public static void hanoi(int n, String from, String mid, String to) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, to, mid);
        System.out.println(from + "--->" + to);
        hanoi(n - 1, mid, from, to);
    }

    public static void hanoiOrder(int n ,String from, String mid, String to) {
        if (n == 0) {
            return;
        }
        hanoiOrder(n -1, from, mid, to);
        System.out.println(from + "--->" + mid);
        hanoiOrder(n - 1, to, mid, from);
        System.out.println(mid + "--->" + to);
        hanoiOrder(n - 1, from, mid, to);
    }


    public static void main(String[] args) {
        hanoiOrder(3, "A", "B", "C");
    }

}
