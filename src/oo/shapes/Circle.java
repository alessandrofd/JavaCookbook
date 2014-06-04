package oo.shapes;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class Circle extends Shape {
    double radius = 2;
    public double computeArea() { return Math.PI * radius * radius; }
}
