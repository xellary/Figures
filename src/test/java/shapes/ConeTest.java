package shapes;

import figures.point.Point;
import figures.shapes.Cone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class ConeTest {
    @Test
    @DisplayName("Cone area and perimeter methods")
    public void ConeAreaAndPerimeterMethods() {

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(3, 0));
        points.add(new Point(0, 0, 4));
        Cone cone = new Cone(points);

        then(cone.validateFigure()).isEqualTo(true);
        then(cone.round(cone.calculateArea())).isEqualTo(75.40);

    }
}

