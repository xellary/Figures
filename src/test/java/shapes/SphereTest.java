package shapes;

import figures.point.Point;
import figures.shapes.Sphere;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class SphereTest {
    @Test
    @DisplayName("Sphere area and perimeter methods")
    public void SphereAreaAndPerimeterMethods() {

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 0, 5));
        Sphere sphere = new Sphere(points);

        then(sphere.figureValidation()).isEqualTo(true);
        sphere.areaCalculation();
        sphere.perimeterCalculation();
        System.out.println("Expected: 314,16");

    }
}
