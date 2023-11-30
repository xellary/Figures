package shapes;

import figures.point.Point;
import figures.shapes.Rectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class RectangleTest {

    @Test
    @DisplayName("Rectangle area and perimeter methods")
    public void RectangleAreaAndPerimeterMethods() {

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(3, 0));
        points.add(new Point(3, 2));
        points.add(new Point(0, 2));
        Rectangle rectangle = new Rectangle(points);

        then(rectangle.validateFigure()).isEqualTo(true);
        then(rectangle.round(rectangle.calculateArea())).isEqualTo(6);
        then(rectangle.round(rectangle.calculatePerimeter())).isEqualTo(10);

        points.clear();
        points.add(new Point(1, 0));
        points.add(new Point(5, 0));
        points.add(new Point(5, 3));
        points.add(new Point(1, 2));
        then(rectangle.validateFigure()).isEqualTo(false);
    }
}
