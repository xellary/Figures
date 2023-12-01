package shapes;

import figures.point.Point;
import figures.shapes.Cylinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class CylinderTest {
    @Test
    @DisplayName("Cylinder area and perimeter methods")
    public void CylinderAreaAndPerimeterMethods() {

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 0, 4));
        points.add(new Point(3, 0));
        Cylinder cylinder = new Cylinder(points);

        then(cylinder.validateFigure()).isEqualTo(true);
        then(cylinder.round(cylinder.calculateArea())).isEqualTo(131.95);

        points.clear();
        points.add(new Point(1, 1, 1));
        points.add(new Point(1, 1, 1));
        points.add(new Point(2, 2, 1));
        cylinder = new Cylinder(points);
        then(cylinder.validateFigure()).isEqualTo(false);
    }
}

