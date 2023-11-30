package shapes;

import figures.point.Point;
import figures.shapes.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class SquareTest {
    @Test
    @DisplayName("Square area and perimeter methods")
    public void SquareAreaAndPerimeterMethods() {

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(2, 0));
        points.add(new Point(2, 2));
        points.add(new Point(0, 2));
        Square square = new Square(points);

        then(square.validateFigure()).isEqualTo(true);
        then(square.round(square.calculateArea())).isEqualTo(4);
        then(square.round(square.calculatePerimeter())).isEqualTo(8);

    }
}
