package shapes;

import figures.point.Point;
import figures.shapes.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class TriangleTest {
    @Test
    @DisplayName("Triangle area and perimeter methods")
    public void TriangleAreaAndPerimeterMethods() {

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(4, 0));
        points.add(new Point(2, 4));
        Triangle triangle = new Triangle(points);

        then(triangle.figureValidation()).isEqualTo(true);
        triangle.areaCalculation();
        triangle.perimeterCalculation();
        System.out.println("Expected: 8,00");
        System.out.println("Expected: 12,94");

    }
}
