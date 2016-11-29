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

        List<Point> points = rectangle.getAllPoints();

        for (Point point : points) {
            int y = point.getY();
        }


        return 0;
    }

    public List<Point> getAllPoints() {
        return coordinates;
    }
}
