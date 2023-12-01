package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Triangle extends Figure {
    private final ArrayList<Point> points;
    private double sideAB;

    private double sideBC;

    private  double sideAC;

    private final Point pointA;

    private final Point pointB;

    private final Point pointC;

    public Triangle(ArrayList<Point> points) {
        this.points = points;
        pointA = points.get(FIRST_POINT_INDEX);
        pointB = points.get(SECOND_POINT_INDEX);
        pointC = points.get(THIRD_POINT_INDEX);
    }

    @Override
    public boolean validateFigure() {
        if (points.size() == AMOUNT_OF_POINTS_THREE) {
            return ((pointB.getX() - pointA.getX())
                    * (pointC.getY() - pointA.getY())
                    - (pointC.getX() - pointA.getX())
                    * (pointB.getY() - pointA.getY())) != 0;
        }
        return false;
    }

    @Override
    public double calculateArea() {
        calculateSides();
        double halfPer = (sideAB + sideBC + sideAC) / 2;
        return Math.sqrt(halfPer * (halfPer - sideAB) * (halfPer - sideBC) * (halfPer - sideAC));
    }

    @Override
    public double calculatePerimeter() {
        calculateSides();
        return sideAB + sideBC + sideAC;
    }

    private void calculateSides() {
        sideAB = calculateLength(pointA, pointB);
        sideBC = calculateLength(pointB, pointC);
        sideAC = calculateLength(pointA, pointC);
    }
}
