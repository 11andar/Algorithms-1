import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> segmentsList = new ArrayList<>();
    private int numberOfSegments;

    public FastCollinearPoints(Point[] points) {
        // TODO: Find all line segments that contain 4 or more points
        if (!isValid(points))
            throw new IllegalArgumentException("points array is not valid");
    }

    private boolean isValid(Point[] points) {
        if (points == null)
            return false;

        HashSet<Point> seen = new HashSet<>();

        for (Point p : points)
            if (!seen.add(p) || p == null)
                return false;
        return true;
    }

    public int numberOfSegments() { return numberOfSegments; }

    public LineSegment[] segments() { return segmentsList.toArray(new LineSegment[0]); }
}
