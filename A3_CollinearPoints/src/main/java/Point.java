import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) { this.x = x; this.y = y; }

    public   void draw(){
        StdDraw.setCanvasSize(900, 900);
        StdDraw.setXscale(0, 32767);
        StdDraw.setYscale(0, 32767);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.015);
        StdDraw.point(this.x, this.y);
        StdDraw.show();
    }

    public void drawTo(Point that) {
        // TODO: draw a line from this point to that point
    }

    public String toString() {
        // TODO: string representation of the point
    }

    public int compareTo(Point that) {
        // TODO: compare points by y-coordinates, tie-breaking by x-coordinates
    }

    public double slopeTo(Point that) {
        // TODO: slope between the invoking point (x0, y0) and the argument point (x1, y1), given by the formula (y1 − y0) / (x1 − x0)
    }

    public Comparator<Point> slopeOrder() {
        // TODO: return a Comparator that compares its two argument points by the slopes they make with the invoking point (x0, y0)
    }
}
