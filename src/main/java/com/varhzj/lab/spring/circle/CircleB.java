package com.varhzj.lab.spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by varhzj on 12/1/16.
 */
@Component
public class CircleB {

    @Autowired
    private CircleA circleA;

    public CircleA getCircleA() {
        return circleA;
    }

    public void setCircleA(CircleA circleA) {
        this.circleA = circleA;
    }
}
