package figures.shapes;

import figures.point.Point;

public class Figure {
    public boolean figureValidation() {
        System.out.println("The figure is figure");
        return true;
    }

    public void areaCalculation() {
        System.out.println("The figure has no area");
    }

    public void perimeterCalculation() {
        System.out.println("The figure has no perimeter");
    }

    protected int lengthCalculation(Point p1, Point p2) {
        int x = p2.getX() - p1.getX();
        int y = p2.getY() - p1.getY();
        int z = p2.getZ() - p1.getZ();
        return (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    protected boolean angleIsEqual(Point p1, Point p2, Point p3) {
        int vector1X = p2.getX() - p1.getX();
        int vector1Y = p2.getY() - p1.getY();
        int vector2X = p3.getX() - p2.getX();
        int vector2Y = p3.getY() - p2.getY();

        return vector1X * vector2X + vector1Y * vector2Y == 0;

    }

    protected boolean AllAnglesAreEqual(Point p1, Point p2, Point p3, Point p4) {
        return angleIsEqual(p1, p2, p3) &&
                angleIsEqual(p2, p3, p4) &&
                angleIsEqual(p3, p4, p1) &&
                angleIsEqual(p4, p1, p2);
    }

    protected void printArea(double area) {
        System.out.printf("The figure area %.2f%n", area);
    }

    protected void printPerimeter(double perimeter) {
        System.out.printf("The figure perimeter %.2f%n", perimeter);
    }
}
