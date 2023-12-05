package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Parallelogram extends Figure {
    private final ArrayList<Point> points;

    private Point pointA;

    private Point pointB;

    private Point pointC;

    private Point pointD;

    public Parallelogram(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean validateFigure() {
        if (points.size() != AMOUNT_OF_POINTS_FOUR) {
            return false;
        }
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (points.get(i).getX() == points.get(j).getX() && points.get(i).getY() == points.get(j).getY()) {
                    return false;
                }
            }
        }
        getPoints();
        int vector1X = pointB.getX() - pointA.getX();
        int vector1Y = pointB.getY() - pointA.getY();
        int vector2X = pointD.getX() - pointC.getX();
        int vector2Y = pointD.getY() - pointC.getY();

        return vector1X * vector2Y - vector1Y * vector2X == 0;
    }

    @Override
    public double calculateArea() {
        getPoints();
        double vectorABx = pointB.getX() - pointA.getX();
        double vectorABy = pointB.getY() - pointA.getY();
        double vectorACx = pointC.getX() - pointA.getX();
        double vectorACy = pointC.getY() - pointA.getY();

        double crossProduct = vectorABx * vectorACy - vectorABy * vectorACx;
        return Math.abs(crossProduct);
    }

    @Override
    public double calculatePerimeter() {
        getPoints();
        double sideAB = calculateLength(pointA, pointB);
        double sideBC = calculateLength(pointB, pointC);
        return 2 * (sideAB + sideBC);
    }

    private void getPoints() {
        pointA = points.get(FIRST_POINT_INDEX);
        pointB = points.get(SECOND_POINT_INDEX);
        pointC = points.get(THIRD_POINT_INDEX);
        pointD = points.get(FOURTH_POINT_INDEX);
    }
}
