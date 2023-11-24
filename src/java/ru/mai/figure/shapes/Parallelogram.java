package ru.mai.figure.shapes;

import ru.mai.figure.point.Point;

import java.util.ArrayList;

import static ru.mai.figure.consts.Consts.*;

public class Parallelogram extends Figure {
    private final ArrayList<Point> points;
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    public Parallelogram(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean figureValidation() {
        if (points.size() != AMOUNT_OF_POINTS_FOUR) {
            return false;
        }
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (points.get(i).x == points.get(j).x && points.get(i).y == points.get(j).y) {
                    return false;
                }
            }
        }
        p1 = points.get(0);
        p2 = points.get(1);
        p3 = points.get(2);
        p4 = points.get(3);
        double[] vectorAB = {p2.x - p1.x, p2.y - p1.y};
        double[] vectorCD = {p4.x - p3.x, p4.y - p3.y};

        double dotProduct = vectorAB[0] * vectorCD[0] + vectorAB[1] * vectorCD[1];
        return dotProduct == 0;
    }

    @Override
    public void areaCalculation() {
        p1 = points.get(0);
        p2 = points.get(1);
        p3 = points.get(2);

        double vectorABx = p2.x - p1.x;
        double vectorABy = p2.y - p1.y;
        double vectorACx = p3.x - p1.x;
        double vectorACy = p3.y - p1.y;

        double crossProduct = vectorABx * vectorACy - vectorABy * vectorACx;
        double area = Math.abs(crossProduct);
        printArea(area);

    }

    @Override
    public void perimeterCalculation() {
        double perimeter = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            perimeter += lengthCalculation(points.get(i), points.get(i + 1));
        }
        perimeter += lengthCalculation(points.get(points.size() - 1), points.get(0));
        printPerimeter(perimeter);
    }
}
