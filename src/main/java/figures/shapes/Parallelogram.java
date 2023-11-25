package figures.shapes;

import figures.point.Point;

import java.util.ArrayList;

import static figures.consts.Consts.*;

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
                if (points.get(i).getX() == points.get(j).getX() && points.get(i).getY() == points.get(j).getY()) {
                    return false;
                }
            }
        }
        p1 = points.get(0);
        p2 = points.get(1);
        p3 = points.get(2);
        p4 = points.get(3);
        int vector1X = p2.getX() - p1.getX();
        int vector1Y = p2.getY() - p1.getY();
        int vector2X = p4.getX() - p3.getX();
        int vector2Y = p4.getY() - p3.getY();

        return vector1X * vector2Y - vector1Y * vector2X == 0;
    }

    @Override
    public void areaCalculation() {
        p1 = points.get(0);
        p2 = points.get(1);
        p3 = points.get(2);

        double vectorABx = p2.getX() - p1.getX();
        double vectorABy = p2.getY() - p1.getY();
        double vectorACx = p3.getX() - p1.getX();
        double vectorACy = p3.getY() - p1.getY();

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
