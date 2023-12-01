package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class Polygon extends Figure {
    private final ArrayList<Point> points;

    private final int amountOfPoints;

    public Polygon(ArrayList<Point> points) {
        this.points = points;
        amountOfPoints = points.size();
    }

    @Override
    public boolean validateFigure() {
        if (amountOfPoints < AMOUNT_OF_POINTS_THREE) {
            return false;
        }

        for (int i = 0; i < amountOfPoints - 2; i++) {
            double crossProduct = (points.get(i + 1).getX() - points.get(i).getX())
                    * (points.get(i + 2).getY() - points.get(i + 1).getY())
                    - (points.get(i + 1).getY() - points.get(i).getY())
                    * (points.get(i + 2).getX() - points.get(i + 1).getX());

            if (crossProduct == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public double calculateArea() {
        double area = 0;
        for (int i = 0; i < amountOfPoints; i++) {
            Point current = points.get(i);
            Point next = points.get((i + 1) % amountOfPoints);
            area += current.getX() * next.getY() - current.getY() * next.getX();
        }
        area = Math.abs(area) / 2.0;
        return area;
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 0;
        for (int i = 0; i < amountOfPoints - 1; i++) {
            perimeter += calculateLength(points.get(i), points.get(i + 1));
        }
        perimeter += calculateLength(points.get(amountOfPoints - 1), points.get(0));
        return perimeter;
    }
}
