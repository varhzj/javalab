package com.varhzj.lab.concurrency.annotations;

import java.lang.annotation.*;

/**
 * Created by varhzj on 11/1/16.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadSafe {
}
