import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void validatePoint(Point point) {
        if (point == null)
            throw new IllegalArgumentException("Point can't be null");
    }

    public void draw() {
        StdDraw.point(this.x, this.y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Point that) {
        validatePoint(that);

        if (this.y < that.y)
                return -1;
        else if (this.y == that.y)
            return Integer.compare(this.x, that.x);
        else
            return 1;
    }

    public double slopeTo(Point that) {
        validatePoint(that);

        if (this.x == that.x) {
            if (this.y == that.y)
                return Double.NEGATIVE_INFINITY;
            else
                return Double.POSITIVE_INFINITY;
        }
        else {
            double slope = (double) (that.y - this.y) / (that.x - this.x);
            if (slope == -0.0)
                return 0.0;
            return slope;
        }
    }

    public Comparator<Point> slopeOrder() {
        return new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                validatePoint(p1);
                validatePoint(p2);

                double s1 = slopeTo(p1);
                double s2 = slopeTo(p2);

                return Double.compare(s1, s2);
            }
        };
    }
}
