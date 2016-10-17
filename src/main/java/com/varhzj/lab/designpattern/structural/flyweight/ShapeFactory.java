package com.varhzj.lab.designpattern.structural.flyweight;

import java.util.HashMap;

/**
 * Created by varhzj on 10/17/16.
 */
public class ShapeFactory {

    public static enum ShapeType {
        LINE, OVAL_FILL, OVAL_NO_FILL;
    }

    private static final HashMap<ShapeType, Shape> shapePool = new HashMap<>();

    public static Shape getShape(ShapeType shapeType) {
        Shape shape = shapePool.get(shapeType);

        if (shape == null) {
            switch (shapeType) {
                case LINE:
                    shape = new Line();
                    break;
                case OVAL_FILL:
                    shape = new Oval(true);
                    break;
                case OVAL_NO_FILL:
                    shape = new Oval(false);
                    break;
            }
            shapePool.put(shapeType, shape);
        }

        return shape;
    }

}
