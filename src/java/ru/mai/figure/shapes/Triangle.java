package ru.mai.figure.shapes;

import ru.mai.figure.point.Point;

import java.util.ArrayList;

import static ru.mai.figure.consts.Consts.*;

public class Triangle extends Figure {
    private final ArrayList<Point> points;
    private double side1;
    private double side2;
    private  double side3;

    public Triangle(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean figureValidation() {
        if (points.size() == AMOUNT_OF_POINTS_THREE) {
            Point p1 = points.get(FIRST_POINT);
            Point p2 = points.get(SECOND_POINT);
            Point p3 = points.get(THIRD_POINT);
            side1 = lengthCalculation(p1, p2);
            side2 = lengthCalculation(p2, p3);
            side3 = lengthCalculation(p1, p3);
            return side1 + side2 > side3 || side2 + side3 > side1 || side1 + side3 > side2;
        }
        return false;
    }

    @Override
    public void areaCalculation() {
        double halfPer = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(halfPer * (halfPer - side1) * (halfPer - side2) * (halfPer - side3));
        printArea(area);
    }

    @Override
    public void perimeterCalculation() {
        double perimeter = side1 + side2 + side3;
        printPerimeter(perimeter);
    }

}
