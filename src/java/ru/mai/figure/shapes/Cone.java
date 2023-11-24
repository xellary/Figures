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

        double[] vector1 = { pointOnCircle.x - center.x, pointOnCircle.y - center.y, pointOnCircle.z - center.z };
        double[] vector2 = { apex.x - center.x, apex.y - center.y, apex.z - center.z };

        double crossProductX = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        double crossProductY = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        double crossProductZ = vector1[0] * vector2[1] - vector1[1] * vector2[0];

        return crossProductX == 0 && crossProductY == 0 && crossProductZ == 0;
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
