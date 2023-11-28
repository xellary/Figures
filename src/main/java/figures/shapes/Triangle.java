package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

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
            side1 = calculateLength(p1, p2);
            side2 = calculateLength(p2, p3);
            side3 = calculateLength(p1, p3);
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
