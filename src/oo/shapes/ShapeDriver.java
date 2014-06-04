package oo.shapes;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class ShapeDriver {
    Collection<Shape> allShapes;

    public ShapeDriver() {
        allShapes = new ArrayList<Shape>();
        allShapes.add(new Circle());
        allShapes.add(new Rectangle());
    }

    public double totalAreas() {
        double total = 0.0;
        for (Shape s : allShapes) {
            total += s.computeArea();
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new ShapeDriver().totalAreas());
    }
}
