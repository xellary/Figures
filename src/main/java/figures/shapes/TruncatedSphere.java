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

        double radiusSquared = Math.pow(pointOnSurface.getX() - center.getX(), 2)
                + Math.pow(pointOnSurface.getY() - center.getY(), 2)
                + Math.pow(pointOnSurface.getZ() - center.getZ(), 2);
        if (radiusSquared <= 0) {
            return false;
        }
        double heightSquared = Math.pow(pointOnCuttingCircle.getX() - center.getX(), 2)
                + Math.pow(pointOnCuttingCircle.getY() - center.getY(), 2)
                + Math.pow(pointOnCuttingCircle.getZ() - center.getZ(), 2);
        return !(heightSquared <= 0);
    }

    @Override
    public void areaCalculation() {
        double radius = Math.sqrt(Math.pow(pointOnSurface.getX() - center.getX(), 2)
                + Math.pow(pointOnSurface.getY() - center.getY(), 2)
                + Math.pow(pointOnSurface.getZ() - center.getZ(), 2));

        double height = Math.sqrt(Math.pow(pointOnCuttingCircle.getX() - center.getX(), 2)
                + Math.pow(pointOnCuttingCircle.getY() - center.getY(), 2)
                + Math.pow(pointOnCuttingCircle.getZ() - center.getZ(), 2));

        double surfaceArea = 2 * Math.PI * radius * (radius + height);

       printArea(surfaceArea);
    }
}
