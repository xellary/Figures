package shapes;

import figures.point.Point;
import figures.shapes.Cylinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class CylinderTest {

    ArrayList<Point> points = new ArrayList<>();

    @Test
    @DisplayName("Cylinder area method")
    public void CylinderAreaMethod() {
        addPointsForValidTest();
        Cylinder cylinder = new Cylinder(points);

        then(cylinder.round(cylinder.calculateArea())).isEqualTo(131.95);
    }

    @Test
    @DisplayName("Cylinder validation method")
    public void CylinderValidationMethod() {
        addPointsForValidTest();
        Cylinder cylinder = new Cylinder(points);
        then(cylinder.validateFigure()).isTrue();

        addPointsForInvalidTest();
        cylinder = new Cylinder(points);
        then(cylinder.validateFigure()).isFalse();
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(0, 0, 4));
        points.add(new Point(3, 0));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(1, 1, 1));
        points.add(new Point(1, 1, 1));
        points.add(new Point(2, 2, 1));
    }
}

