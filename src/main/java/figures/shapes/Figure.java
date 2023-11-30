package figures.shapes;

import figures.point.Point;

public class Figure {

    public boolean validateFigure() {
        System.out.println("The figure is figure");
        return true;
    }

    public double calculateArea() {
        return 0;
    }

    public double calculatePerimeter() {
        return 0;
    }

    public double round(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    public void printArea(double area) {
        if (area == 0) {
            System.out.println("The figure has no area");
        } else {
            System.out.printf("The figure area %.2f%n", area);
        }
    }

    public void printPerimeter(double perimeter) {
        if (perimeter == 0) {
            System.out.println("The figure has no perimeter");
        } else {
            System.out.printf("The figure perimeter %.2f%n", perimeter);
        }
    }

    protected double calculateLength(Point pointA, Point pointB) {
        int x = pointB.getX() - pointA.getX();
        int y = pointB.getY() - pointA.getY();
        int z = pointB.getZ() - pointA.getZ();
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    protected boolean isAngleEqual(Point pointA, Point pointB, Point pointC) {
        int vector1X = pointB.getX() - pointA.getX();
        int vector1Y = pointB.getY() - pointA.getY();
        int vector2X = pointC.getX() - pointB.getX();
        int vector2Y = pointC.getY() - pointB.getY();

        return vector1X * vector2X + vector1Y * vector2Y == 0;

    }

    protected boolean areAllAnglesEqual(Point pointA, Point pointB, Point pointC, Point pointD) {
        return isAngleEqual(pointA, pointB, pointC)
                && isAngleEqual(pointB, pointC, pointD)
                && isAngleEqual(pointC, pointD, pointA)
                && isAngleEqual(pointD, pointA, pointB);
    }
}
