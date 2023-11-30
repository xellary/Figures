package figures.shapes;
import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Square extends Figure {
    private final ArrayList<Point> points;

    private double sideAB;

    private double sideBC;

    private double sideCD;

    private double sideAD;

    public Square(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean validateFigure() {
        if (points.size() == AMOUNT_OF_POINTS_FOUR) {
            Point pointA = points.get(FIRST_POINT);
            Point pointB = points.get(SECOND_POINT);
            Point pointC = points.get(THIRD_POINT);
            Point pointD = points.get(FOURTH_POINT);
            sideAB = calculateLength(pointA, pointB);
            sideBC = calculateLength(pointB, pointC);
            sideCD = calculateLength(pointC, pointD);
            sideAD = calculateLength(pointA, pointD);
            return sidesAreEqual() && areAllAnglesEqual(pointA, pointB, pointC, pointD);
        }
        return false;
    }

    @Override
    public double calculateArea() {
        return Math.pow(sideAB, 2);
    }

    @Override
    public double calculatePerimeter() {
        return sideAB * AMOUNT_OF_POINTS_FOUR;
    }

    private boolean sidesAreEqual() {
        return sideAB == sideBC && sideCD == sideAD && sideAB == sideCD;
    }

}
