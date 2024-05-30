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
        // TODO: slope between the invoking point (x0, y0) and the argument point (x1, y1), given by the formula (y1 − y0) / (x1 − x0)
    }

    public Comparator<Point> slopeOrder() {
        // TODO: return a Comparator that compares its two argument points by the slopes they make with the invoking point (x0, y0)
    }
}
