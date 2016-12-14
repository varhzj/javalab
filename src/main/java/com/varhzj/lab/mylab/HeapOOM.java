package com.varhzj.lab.mylab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varhzj on 11/15/16.
 * VM args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+HeapDumpOnOutOfMemoryError
 *          -XX:PrintGCDetails
 */
public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
