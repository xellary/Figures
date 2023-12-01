package shapes;

import figures.point.Point;
import figures.shapes.Polygon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class PolygonTest {

    ArrayList<Point> points = new ArrayList<>();

    @Test
    @DisplayName("Polygon area and perimeter methods")
    public void PolygonAreaAndPerimeterMethods() {

        addPointsForValidTest();
        Polygon polygon = new Polygon(points);

        then(polygon.round(polygon.calculateArea())).isEqualTo(28.5);
        then(polygon.round(polygon.calculatePerimeter())).isEqualTo(21.43);
    }

    @Test
    @DisplayName("Polygon validation method")
    public void PolygonValidationMethod() {
        addPointsForValidTest();
        Polygon polygon = new Polygon(points);
        then(polygon.validateFigure()).isEqualTo(true);

        addPointsForInvalidTest();
        polygon = new Polygon(points);
        then(polygon.validateFigure()).isEqualTo(false);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 3));
        points.add(new Point(1, 7));
        points.add(new Point(5, 8));
        points.add(new Point(6, 6));
        points.add(new Point(3, 0));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(1, 1));
        points.add(new Point(2, 3));
        points.add(new Point(1, 3));
        points.add(new Point(2, 3));
    }
}
