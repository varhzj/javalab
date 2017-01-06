package com.varhzj.lab.mylab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by varhzj on 12/16/16.
 */
public class RemoveExpl {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(5));
        }
        System.out.println(list);
//        list.remove(new Integer(1));
//        System.out.println(list);
        // ConcurrentModificationException
//        for (Integer i : list) {
//            if (i == 1) {
//                list.remove(i);
//            }
//        }
        // 正确的方法
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer el = itr.next();
            if (el == 1) {
                itr.remove();
            }
        }
        System.out.println(list);
    }
}
