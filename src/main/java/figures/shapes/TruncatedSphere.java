package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

public class TruncatedSphere extends Figure {
    private final ArrayList<Point> points;

    private Point center;

    private Point pointOnSurface;

    private Point pointOnCuttingCircle;

    public TruncatedSphere(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean figureValidation() {
        if (points.size() != AMOUNT_OF_POINTS_THREE) {
            return false;
        }
        center = points.get(0);
        pointOnSurface = points.get(1);
        pointOnCuttingCircle = points.get(2);

        if (center.getX() == pointOnSurface.getX()
                && center.getY() == pointOnSurface.getY()
                && center.getZ() == pointOnSurface.getZ()) {
            return false;
        }
        double[] vector1 = {
                pointOnSurface.getX() - center.getX(),
                pointOnSurface.getY() - center.getY(),
                pointOnSurface.getZ() - center.getZ()};
        double[] vector2 = {
                pointOnCuttingCircle.getX() - center.getX(),
                pointOnCuttingCircle.getY() - center.getY(),
                pointOnCuttingCircle.getZ() - center.getZ()};
        double dotProduct = vector1[0] * vector2[0] + vector1[1] * vector2[1] + vector1[2] * vector2[2];
        if (dotProduct != 0) {
            return false;
        }

        double radiusSquared = calculateLength(pointOnSurface, center);
        if (radiusSquared <= 0) {
            return false;
        }
        double heightSquared = calculateLength(pointOnCuttingCircle, center);
        return !(heightSquared <= 0);
    }

    @Override
    public void areaCalculation() {
        double radius = calculateLength(pointOnSurface, center);
        double height = calculateLength(pointOnCuttingCircle, center);
        double surfaceArea = 2 * Math.PI * radius * (radius + height);
        printArea(surfaceArea);
    }
}
