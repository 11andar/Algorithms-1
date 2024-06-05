import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> segmentsList = new ArrayList<>();
    private int numberOfSegments;

    private class Tuple {
        private final double slope;
        private final Point point;

        public Tuple(double slope, Point point) {
            this.slope = slope;
            this.point = point;
        }
    }

    public FastCollinearPoints(Point[] points) {
        // TODO: Find all line segments that contain 4 or more points
        if (!isValid(points))
            throw new IllegalArgumentException("points array is not valid");

    }

    private boolean isValid(Point[] points) {
        if (points == null)
            return false;

        for (int i = 0; i < points.length-1; i++)
            for (int j = i+1; j < points.length; j++)
                if (points[i] == null || points[j] == null || points[i] == points[j])
                    return false;
        return true;
    }

    public int numberOfSegments() { return numberOfSegments; }

    public LineSegment[] segments() { return segmentsList.toArray(new LineSegment[0]); }
}
