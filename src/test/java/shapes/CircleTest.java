package shapes;

import figures.point.Point;
import figures.shapes.Circle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class CircleTest {

    @Test
    @DisplayName("Circle area and perimeter methods")
    public void CircleAreaAndPerimeterMethods() {

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(2, 0));
        Circle circle = new Circle(points);

        then(circle.validateFigure()).isEqualTo(true);
        then(circle.round(circle.calculateArea())).isEqualTo(12.57);
        then(circle.round(circle.calculatePerimeter())).isEqualTo(12.57);
    }
}
