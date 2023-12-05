package shapes;

import figures.point.Point;
import figures.shapes.Cone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class ConeTest {

    ArrayList<Point> points = new ArrayList<>();

    @Test
    @DisplayName("Cone area method")
    public void ConeAreaMethod() {
        addPointsForValidTest();
        Cone cone = new Cone(points);

        then(cone.round(cone.calculateArea())).isEqualTo(75.40);
    }

    @Test
    @DisplayName("Cone validation method")
    public void ConeValidationMethod() {
        addPointsForValidTest();
        Cone cone = new Cone(points);
        then(cone.validateFigure()).isTrue();

        addPointsForInvalidTest();
        cone = new Cone(points);
        then(cone.validateFigure()).isFalse();
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(3, 0));
        points.add(new Point(0, 0, 4));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(1, 1, 0));
        points.add(new Point(0, 3, 0));
        points.add(new Point(1, 1, 0));
    }
}

