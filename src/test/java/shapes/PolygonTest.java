package shapes;

import figures.point.Point;
import figures.shapes.Polygon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class PolygonTest {
    @Test
    @DisplayName("Polygon area and perimeter methods")
    public void PolygonAreaAndPerimeterMethods() {

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(4, 0));
        points.add(new Point(6, 2));
        points.add(new Point(2, 2));
        Polygon polygon = new Polygon(points);

        then(polygon.figureValidation()).isEqualTo(true);
        polygon.areaCalculation();
        polygon.perimeterCalculation();
        System.out.println("Expected: ");
        System.out.println("Expected: ");
    }
}
