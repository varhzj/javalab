package com.varhzj.lab.spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by varhzj on 12/1/16.
 */
@Component
public class CircleA {

    @Autowired
    private CircleB circleB;

    public CircleB getCircleB() {
        return circleB;
    }

    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }
}
