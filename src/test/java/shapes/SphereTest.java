package shapes;

import figures.point.Point;
import figures.shapes.Sphere;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class SphereTest {

    ArrayList<Point> points = new ArrayList<>();

    @Test
    @DisplayName("Sphere area method")
    public void SphereAreaMethod() {

        addPointsForValidTest();
        Sphere sphere = new Sphere(points);

        then(sphere.validateFigure()).isEqualTo(true);
        then(sphere.round(sphere.calculateArea())).isEqualTo(314.16);
    }

    @Test
    @DisplayName("Sphere validation method")
    public void SphereValidationMethod() {
        addPointsForValidTest();
        Sphere sphere = new Sphere(points);
        then(sphere.validateFigure()).isEqualTo(true);

        addPointsForInvalidTest();
        sphere = new Sphere(points);
        then(sphere.validateFigure()).isEqualTo(false);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(0, 0, 5));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(1, 1, 5));
        points.add(new Point(1, 1, 5));
    }
}
