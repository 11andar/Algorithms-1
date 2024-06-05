import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private final ArrayList<LineSegment> segmentsList = new ArrayList<LineSegment>();


    public BruteCollinearPoints(Point[] points) {
        if (!isValid(points))
            throw new IllegalArgumentException("point can't be null");

        for (int i = 0; i < points.length-3; i++) {
            for (int j = i+1; j < points.length-2; j++) {
                for (int k = j+1; k < points.length-1; k++) {
                    for (int m = k+1; m < points.length; m++) {
                        Point p1 = points[i], p2 = points[j], p3 = points[k], p4 = points[m];

                        if (p1.slopeTo(p2) == p1.slopeTo(p3) && p1.slopeTo(p2) == p1.slopeTo(p4)) {
                            Point[] segment = {p1, p2, p3, p4};
                            Arrays.sort(segment);
                            LineSegment tempSegment = new LineSegment(segment[0], segment[3]);
                            if (!segmentsList.contains(tempSegment))
                                segmentsList.add(tempSegment);
                        }
                    }
                }
            }
        }

    }

    private boolean isValid(Point[] points) {
        if (points == null)
            return false;

        for (int i = 0; i < points.length-1; i++)
            for (int j = i+1; j < points.length; j++)
                if (points[i] == null || points[j] == null || points[i].compareTo(points[j]) == 0)
                    return false;
        return true;
    }

    public int numberOfSegments() {
        return segmentsList.size();
    }

    public LineSegment[] segments() {
        return segmentsList.toArray(new LineSegment[segmentsList.size()]);
    }
}