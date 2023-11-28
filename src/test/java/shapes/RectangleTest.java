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

        then(rectangle.figureValidation()).isEqualTo(true);
        rectangle.areaCalculation();
        rectangle.perimeterCalculation();
        System.out.println("Expected: 6,00");
        System.out.println("Expected: 10,00");

    }
}
