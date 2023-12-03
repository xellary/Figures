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
    public boolean validateFigure() {
        if (points.size() != AMOUNT_OF_POINTS_THREE) {
            return false;
        }

        getPoints();
        if (center.getX() == pointOnSurface.getX()
                && center.getY() == pointOnSurface.getY()
                && center.getZ() == pointOnSurface.getZ()) {
            return false;
        }
        double[] vector1 = getVector(pointOnSurface, center);
        double[] vector2 = getVector(pointOnCuttingCircle, center);

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
    public double calculateArea() {
        getPoints();
        double radius = calculateLength(pointOnSurface, center);
        double height = radius - pointOnCuttingCircle.getZ();
        double sideSurface = 2 * radius * height * Math.PI;
        double baseSurface = Math.PI * height * (2 * radius - height);
        return sideSurface + baseSurface;
    }

    private double[] getVector(Point pointA, Point pointB) {
        return new double[]{
                pointA.getX() - pointB.getX(),
                pointA.getY() - pointB.getY(),
                pointA.getZ() - pointB.getZ()};
    }

    private void getPoints() {
        center = points.get(FIRST_POINT_INDEX);
        pointOnSurface = points.get(SECOND_POINT_INDEX);
        pointOnCuttingCircle = points.get(THIRD_POINT_INDEX);
    }
}
