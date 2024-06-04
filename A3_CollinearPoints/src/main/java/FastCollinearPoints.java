import java.util.HashSet;

public class FastCollinearPoints {
    public FastCollinearPoints(Point[] points) {
        // TODO: Find all line segments that contain 4 or more points

    }

    private boolean isValid(Point[] points) {
        HashSet<Point> seen = new HashSet<>();

        for (Point p : points)
            if (!seen.add(p) || p == null)
                return false;
        return true;
    }

    public int numberOfSegments() {
        // TODO: Return number of line segments
    }

    public LineSegment[] segments() {
        // TODO: Return array of existing line segments
    }
}
