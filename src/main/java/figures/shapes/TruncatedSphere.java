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

        if (center.x == pointOnSurface.x && center.y == pointOnSurface.y && center.z == pointOnSurface.z) {
            return false;
        }
        double[] vector1 = {
                pointOnSurface.x - center.x,
                pointOnSurface.y - center.y,
                pointOnSurface.z - center.z};
        double[] vector2 = {
                pointOnCuttingCircle.x - center.x,
                pointOnCuttingCircle.y - center.y,
                pointOnCuttingCircle.z - center.z};
        double dotProduct = vector1[0] * vector2[0] + vector1[1] * vector2[1] + vector1[2] * vector2[2];
        if (dotProduct != 0) {
            return false;
        }

        double radiusSquared = Math.pow(pointOnSurface.x - center.x, 2)
                + Math.pow(pointOnSurface.y - center.y, 2)
                + Math.pow(pointOnSurface.z - center.z, 2);
        if (radiusSquared <= 0) {
            return false;
        }
        double heightSquared = Math.pow(pointOnCuttingCircle.x - center.x, 2)
                + Math.pow(pointOnCuttingCircle.y - center.y, 2)
                + Math.pow(pointOnCuttingCircle.z - center.z, 2);
        return !(heightSquared <= 0);
    }

    @Override
    public void areaCalculation() {
        double radius = Math.sqrt(Math.pow(pointOnSurface.x - center.x, 2)
                + Math.pow(pointOnSurface.y - center.y, 2)
                + Math.pow(pointOnSurface.z - center.z, 2));

        double height = Math.sqrt(Math.pow(pointOnCuttingCircle.x - center.x, 2)
                + Math.pow(pointOnCuttingCircle.y - center.y, 2)
                + Math.pow(pointOnCuttingCircle.z - center.z, 2));

        double surfaceArea = 2 * Math.PI * radius * (radius + height);

       printArea(surfaceArea);
    }
}
