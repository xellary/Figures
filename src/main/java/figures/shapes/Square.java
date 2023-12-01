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

    private final Point pointA;

    private final Point pointB;

    private final Point pointC;

    private final Point pointD;

    public Square(ArrayList<Point> points) {
        this.points = points;
        pointA = points.get(FIRST_POINT_INDEX);
        pointB = points.get(SECOND_POINT_INDEX);
        pointC = points.get(THIRD_POINT_INDEX);
        pointD = points.get(FOURTH_POINT_INDEX);
    }

    @Override
    public boolean validateFigure() {
        if (points.size() == AMOUNT_OF_POINTS_FOUR) {
            calculateSides();
            return sidesAreEqual() && areAllAnglesEqual(pointA, pointB, pointC, pointD);
        }
        return false;
    }

    @Override
    public double calculateArea() {
        calculateSides();
        return Math.pow(sideAB, 2);
    }

    @Override
    public double calculatePerimeter() {
        calculateSides();
        return sideAB * AMOUNT_OF_POINTS_FOUR;
    }

    private boolean sidesAreEqual() {
        return sideAB == sideBC && sideCD == sideAD && sideAB == sideCD;
    }

    private void calculateSides() {
        sideAB = calculateLength(pointA, pointB);
        sideBC = calculateLength(pointB, pointC);
        sideCD = calculateLength(pointC, pointD);
        sideAD = calculateLength(pointA, pointD);
    }
}
