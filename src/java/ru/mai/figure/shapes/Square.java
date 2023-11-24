package ru.mai.figure.shapes;
import ru.mai.figure.point.Point;

import java.util.ArrayList;

import static ru.mai.figure.consts.Consts.*;

public class Square extends Figure {
    private final ArrayList<Point> points;
    private double side1;
    private double side2;
    private double side3;
    private double side4;

    public Square(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean figureValidation() {
        if (points.size() == AMOUNT_OF_POINTS_FOUR) {
            Point p1 = points.get(FIRST_POINT);
            Point p2 = points.get(SECOND_POINT);
            Point p3 = points.get(THIRD_POINT);
            Point p4 = points.get(FOURTH_POINT);
            side1 = lengthCalculation(p1, p2);
            side2 = lengthCalculation(p2, p3);
            side3 = lengthCalculation(p1, p3);
            side4 = lengthCalculation(p3, p4);
            return sidesAreEqual() && AllAnglesAreEqual(p1, p2, p3, p4);
        }
        return false;
    }

    @Override
    public void areaCalculation() {
        double area = Math.pow(side1, 2);
        printArea(area);
    }

    @Override
    public void perimeterCalculation() {
        double perimeter = side1 * AMOUNT_OF_POINTS_FOUR;
        printPerimeter(perimeter);
    }

    private boolean sidesAreEqual() {
        return side1 == side2 && side3 == side4 && side1 == side3;
    }

}
