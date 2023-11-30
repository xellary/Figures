package shapes;

import figures.point.Point;
import figures.shapes.TruncatedSphere;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class TruncatedSphereTest {
    @Test
    @DisplayName("Truncated Sphere area and perimeter methods")
    public void TruncatedSphereAreaAndPerimeterMethods() {

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 5));
        points.add(new Point(0, 0, 4));
        TruncatedSphere truncatedSphere = new TruncatedSphere(points);

        then(truncatedSphere.validateFigure()).isEqualTo(true);
        then(truncatedSphere.round(truncatedSphere.calculateArea())).isEqualTo(59.69);
    }
}
