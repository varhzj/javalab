package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by varhzj on 11/2/16.
 * A object is immutable if:
 *  Its state cannot be modified after construction;
 *  All its fields are final; and
 *  It is properly constructed (then this reference does not escape during construction).
 */
@Immutable
public final class ThreeStooges {

    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        stooges.add("Ruby");
        stooges.add("Python");
        stooges.add("Perl");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }

}
