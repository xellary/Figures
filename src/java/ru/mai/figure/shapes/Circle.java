package ru.mai.figure.shapes;
import ru.mai.figure.point.Point;

import java.util.ArrayList;
import static ru.mai.figure.consts.Consts.*;
public class Circle extends Figure {
    private final ArrayList<Point> points;
    private Point p1;
    private Point p2;
    public Circle(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean figureValidation() {
        if (points.size() == AMOUNT_OF_POINTS_CIRCLE) {
            p1 = points.get(FIRST_POINT);
            p2 = points.get(SECOND_POINT);
            return !(p1.x == p2.x && p1.y == p2.y && p1.z == p2.z);
        }
        return false;
    }

    @Override
    public void areaCalculation() {
        double radius = lengthCalculation(p1, p2);
        double area = Math.PI * Math.pow(radius, 2);
        printArea(area);
    }

    @Override
    public void perimeterCalculation() {
        double radius = lengthCalculation(p1, p2);
        double perimeter = Math.PI * 2 * radius;
        printPerimeter(perimeter);
    }
}
