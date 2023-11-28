package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Rectangle extends Figure {
    private final ArrayList<Point> points;

    private double side1;

    private double side2;

    private double side3;

    private double side4;

    public Rectangle(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean figureValidation() {
        if (points.size() == AMOUNT_OF_POINTS_FOUR) {
            Point p1 = points.get(FIRST_POINT);
            Point p2 = points.get(SECOND_POINT);
            Point p3 = points.get(THIRD_POINT);
            Point p4 = points.get(FOURTH_POINT);
            side1 = calculateLength(p1, p2);
            side2 = calculateLength(p2, p3);
            side3 = calculateLength(p3, p4);
            side4 = calculateLength(p1, p4);
            return areAllAnglesEqual(p1, p2, p3, p4) && (side1 == side3 && side2 == side4);
        }
        return false;
    }

    @Override
    public void areaCalculation() {
        double area = side1 * side2;
        printArea(area);
    }

    @Override
    public void perimeterCalculation() {
        double perimeter = (side1 + side2) * 2;
        printPerimeter(perimeter);
    }
}
