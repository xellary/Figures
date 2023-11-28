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

        then(square.figureValidation()).isEqualTo(true);
        square.areaCalculation();
        square.perimeterCalculation();
        System.out.println("Expected: 4,00");
        System.out.println("Expected: 8,00");

    }
}