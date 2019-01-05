package com.varhzj.lab.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Object[] array = list.toArray();

        String[] sArr = new String[2];
        // Returns an array containing all of the elements in this list in
        // proper sequence (from first to last element); the runtime type of
        // the returned array is that of the specified array.  If the list fits
        // in the specified array, it is returned therein.  Otherwise, a new
        // array is allocated with the runtime type of the specified array and
        // the size of this list.
        String[] sArr2 = list.toArray(sArr);
        System.out.println(Arrays.asList(sArr)); // "[null, null]"
        System.out.println(Arrays.asList(sArr2)); // "[one, two, three]"

        String[] sArr3 = new String[3];
        list.toArray(sArr3);
        System.out.println(Arrays.asList(sArr3)); // "[one, two, three]"

        String[] sArr4 = new String[5];
        list.toArray(sArr4);
        System.out.println(Arrays.asList(sArr4)); // "[one, two, three, null, null]"
    }

}
