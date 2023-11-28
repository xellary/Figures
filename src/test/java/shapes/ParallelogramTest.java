package shapes;

import figures.point.Point;
import figures.shapes.Parallelogram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class ParallelogramTest {

    @Test
    @DisplayName("Parallelogram area and perimeter methods")
    public void ParallelogramAreaAndPerimeterMethods() {

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(4, 0));
        points.add(new Point(6, 2));
        points.add(new Point(2, 2));
        Parallelogram parallelogram = new Parallelogram(points);

        then(parallelogram.figureValidation()).isEqualTo(true);
        parallelogram.areaCalculation();
        parallelogram.perimeterCalculation();
        System.out.println("Expected: 8,00");
        System.out.println("Expected: 13,66");

    }
}

