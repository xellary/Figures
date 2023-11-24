package ru.mai.figure.shapes;

import ru.mai.figure.point.Point;

import java.util.ArrayList;

import static ru.mai.figure.consts.Consts.*;

public class Cone extends Figure {
    private final ArrayList<Point> points;
    private Point center;
    private Point pointOnCircle;
    private Point apex;
    public Cone(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean figureValidation() {
        if (points.size() != AMOUNT_OF_POINTS_THREE) {
            return false;
        }
        center = points.get(0);
        pointOnCircle = points.get(1);
        apex = points.get(2);

        double radius = lengthCalculation(center, pointOnCircle);
        double height = lengthCalculation(center, apex);

        return radius > 0 && height > 0;
    }

    @Override
    public void areaCalculation() {
        double radius = Math.sqrt(Math.pow(pointOnCircle.x - center.x, 2)
                + Math.pow(pointOnCircle.y - center.y, 2)
                + Math.pow(pointOnCircle.z - center.z, 2));

        double height = Math.sqrt(Math.pow(apex.x - center.x, 2)
                + Math.pow(apex.y - center.y, 2)
                + Math.pow(apex.z - center.z, 2));

        double surfaceArea = Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
        printArea(surfaceArea);
    }
}
