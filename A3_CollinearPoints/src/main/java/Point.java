import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) { this.x = x; this.y = y; }

    public   void draw(){
        StdDraw.point(this.x, this.y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Point that) {
        if (this.y < that.y)
                return -1;
        else if (this.y == that.y)
            return Integer.compare(this.x, that.x);
        else
            return 1;
    }

    public double slopeTo(Point that) {
        if (this.x == that.x) {
            if (this.y == that.y)
                return Double.NEGATIVE_INFINITY;
            else
                return Double.POSITIVE_INFINITY;
        }
        else
            return (double) (that.y - this.y) /(that.x - this.x);
    }

    public Comparator<Point> slopeOrder() {
        // TODO: return a Comparator that compares its two argument points by the slopes they make with the invoking point (x0, y0)
    }
}
