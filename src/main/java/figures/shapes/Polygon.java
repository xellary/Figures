package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

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
        if (first.getX() != last.getX() || first.getY() != last.getY()) {
            return false;
        }

        n = points.size();
        for (int i = 0; i < n - 2; i++) {
            double crossProduct = (points.get(i + 1).getX() - points.get(i).getX()) * (points.get(i + 2).getY() - points.get(i + 1).getY())
                    - (points.get(i + 1).getY() - points.get(i).getY()) * (points.get(i + 2).getX() - points.get(i + 1).getX());

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

            area += current.getX() * next.getY() - current.getY() * next.getX();
        }
        area = Math.abs(area) / 2.0;
        printArea(area);
    }

    @Override
    public void perimeterCalculation() {
        double perimeter = 0;
        for (int i = 0; i < n - 1; i++) {
            perimeter += calculateLength(points.get(i), points.get(i + 1));
        }
        perimeter += calculateLength(points.get(n - 1), points.get(0));
        printPerimeter(perimeter);
    }
}
