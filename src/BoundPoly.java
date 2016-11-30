import java.util.ArrayList;
import java.util.List;

public class BoundPoly {

    private List<Point> coordinates;

    public BoundPoly(Point a, Point b, Point c, Point d) {
        coordinates.add(a);
        coordinates.add(b);
        coordinates.add(c);
        coordinates.add(d);
    }

    public int getMaxY(BoundPoly rectangle) {

        int result;
        List<Point> points = rectangle.getAllPoints();

        int temp = 0;
        for (Point point : points) {
            if (temp == 0)
                temp = point.getY();

        }



        return 0;
    }

    public List<Point> getAllPoints() {
        return coordinates;
    }
}
