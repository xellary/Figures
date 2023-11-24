package ru.mai.figure.shapes;

import ru.mai.figure.point.Point;

import java.util.ArrayList;

import static ru.mai.figure.consts.Consts.*;

public class Polygon extends Figure {
    private final ArrayList<Point> points;
    private int n;
    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean figureValidation() {
        if (points.size() < AMOUNT_OF_POINTS_THREE) {
            return false;
        }
        Point first = points.get(0);
        Point last = points.get(points.size() - 1);
        if (first.x != last.x || first.y != last.y) {
            return false;
        }

        n = points.size();
        for (int i = 0; i < n - 2; i++) {
            double crossProduct = (points.get(i + 1).x - points.get(i).x) * (points.get(i + 2).y - points.get(i + 1).y)
                    - (points.get(i + 1).y - points.get(i).y) * (points.get(i + 2).x - points.get(i + 1).x);

            if (crossProduct == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void areaCalculation() {
        double area = 0;
        for (int i = 0; i < n; i++) {
            Point current = points.get(i);
            Point next = points.get((i + 1) % n);

            area += current.x * next.y - current.y * next.x;
        }
        area = Math.abs(area) / 2.0;
        printArea(area);
    }

    @Override
    public void perimeterCalculation() {
        double perimeter = 0;
        for (int i = 0; i < n - 1; i++) {
            perimeter += lengthCalculation(points.get(i), points.get(i + 1));
        }
        perimeter += lengthCalculation(points.get(n - 1), points.get(0));
        printPerimeter(perimeter);
    }
}
