import edu.princeton.cs.algs4.StdDraw;

public class LineSegment {
    private final Point p;
    private final Point q;

    public LineSegment(Point p, Point q) {
        if (p == null || q == null)
            throw new IllegalArgumentException("Line segment points can't be null");
        this.p = p;
        this.q = q;
    }

    public void draw() {
        // TODO: Draw this line segment
    }

    public String toString() {
        // TODO: String representation
    }
}
