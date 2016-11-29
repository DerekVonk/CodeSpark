import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int maxYfirst = maxY(1909, 1909, 2023, 2023);
        int minYSecond = minY(1809, 1809, 1881, 1881);
        int maxYthird = maxY(1358, 1358, 1779, 1779);
        int maxYfourth = maxY(1846, 1846, 1907, 1907);

        List<Point> boundPolyOne = new ArrayList<>();
        boundPolyOne.add(new Point(708, 1846));
        boundPolyOne.add(new Point(708, 1846));
        boundPolyOne.add(new Point(778, 1907));
        boundPolyOne.add(new Point(778, 1907));

        List<Point> boundPolyTwo = new ArrayList<>();
        boundPolyOne.add(new Point(708, 1358));
        boundPolyOne.add(new Point(708, 1358));
        boundPolyOne.add(new Point(710, 1779));
        boundPolyOne.add(new Point(651, 1779));

        if (maxYfirst > minYSecond) {

        }


        List<Integer> lines = new ArrayList<>();



        System.out.println("Hello World!");
    }






    public static int maxY(int a, int b, int c, int d) {

        return Math.max(Math.max(Math.max(a, b), c),d);
    }

    public static int minY(int a, int b, int c, int d) {

        return Math.min(Math.min(Math.min(a, b), c),d);
    }



}
