package com.varhzj.lab.concurrency.annotations;

import java.lang.annotation.*;

/**
 * Created by varhzj on 11/1/16.
 */
@Documented
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GuardedBy {

    String value() default "";

}
