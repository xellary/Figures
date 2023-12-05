package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Triangle extends Figure {
    private final ArrayList<Point> points;
    private double sideAB;

    private double sideBC;

    private  double sideAC;

    private Point pointA;

    private Point pointB;

    private Point pointC;

    public Triangle(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean validateFigure() {
        if (points.size() == AMOUNT_OF_POINTS_THREE) {
            getPoints();
            return (pointB.getX() - pointA.getX())
                    * (pointC.getY() - pointA.getY())
                    - (pointC.getX() - pointA.getX())
                    * (pointB.getY() - pointA.getY()) != 0;
        }
        return false;
    }

    @Override
    public double calculateArea() {
        getPoints();
        calculateSides();
        double halfPer = calculatePerimeter() / 2;
        return Math.sqrt(halfPer * (halfPer - sideAB) * (halfPer - sideBC) * (halfPer - sideAC));
    }

    @Override
    public double calculatePerimeter() {
        getPoints();
        calculateSides();
        return sideAB + sideBC + sideAC;
    }

    private void calculateSides() {
        sideAB = calculateLength(pointA, pointB);
        sideBC = calculateLength(pointB, pointC);
        sideAC = calculateLength(pointA, pointC);
    }

    private void getPoints() {
        pointA = points.get(FIRST_POINT_INDEX);
        pointB = points.get(SECOND_POINT_INDEX);
        pointC = points.get(THIRD_POINT_INDEX);
    }
}
