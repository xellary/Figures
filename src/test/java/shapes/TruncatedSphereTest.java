package shapes;

import figures.point.Point;
import figures.shapes.TruncatedSphere;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class TruncatedSphereTest {

    ArrayList<Point> points = new ArrayList<>();

    @Test
    @DisplayName("Truncated Sphere area method")
    public void TruncatedSphereAreaMethod() {
        addPointsForValidTest();
        TruncatedSphere truncatedSphere = new TruncatedSphere(points);

        then(truncatedSphere.round(truncatedSphere.calculateArea())).isEqualTo(59.69);
    }

    @Test
    @DisplayName("Truncated Sphere validation method")
    public void TruncatedSphereValidationMethod() {
        addPointsForValidTest();
        TruncatedSphere truncatedSphere = new TruncatedSphere(points);
        then(truncatedSphere.validateFigure()).isTrue();

        addPointsForInvalidTest();
        truncatedSphere = new TruncatedSphere(points);
        then(truncatedSphere.validateFigure()).isFalse();
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0, 0));
        points.add(new Point(0, 5, 0));
        points.add(new Point(0, 0, 4));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(0, 0, 0));
        points.add(new Point(0, 5, 5));
        points.add(new Point(0, 6, 1));
    }
}
