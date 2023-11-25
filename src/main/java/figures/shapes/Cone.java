package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

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
        double radius = Math.sqrt(Math.pow(pointOnCircle.getX() - center.getX(), 2)
                + Math.pow(pointOnCircle.getY() - center.getY(), 2)
                + Math.pow(pointOnCircle.getZ() - center.getZ(), 2));

        double height = Math.sqrt(Math.pow(apex.getX() - center.getX(), 2)
                + Math.pow(apex.getY() - center.getY(), 2)
                + Math.pow(apex.getZ() - center.getZ(), 2));

        double surfaceArea = Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
        printArea(surfaceArea);
    }
}
