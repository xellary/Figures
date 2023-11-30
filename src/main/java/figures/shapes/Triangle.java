package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Triangle extends Figure {
    private final ArrayList<Point> points;
    private double sideAB;

    private double sideBC;

    private  double sideAC;

    public Triangle(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean validateFigure() {
        if (points.size() == AMOUNT_OF_POINTS_THREE) {
            Point pointA = points.get(FIRST_POINT);
            Point pointB = points.get(SECOND_POINT);
            Point pointC = points.get(THIRD_POINT);
            sideAB = calculateLength(pointA, pointB);
            sideBC = calculateLength(pointB, pointC);
            sideAC = calculateLength(pointA, pointC);
            return ((pointB.getX() - pointA.getX())
                    * (pointC.getY() - pointA.getY())
                    - (pointC.getX() - pointA.getX())
                    * (pointB.getY() - pointA.getY())) != 0;
        }
        return false;
    }

    @Override
    public double calculateArea() {
        double halfPer = (sideAB + sideBC + sideAC) / 2;
        return Math.sqrt(halfPer * (halfPer - sideAB) * (halfPer - sideBC) * (halfPer - sideAC));
    }

    @Override
    public double calculatePerimeter() {
        return sideAB + sideBC + sideAC;
    }
}
