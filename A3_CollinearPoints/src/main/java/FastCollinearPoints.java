import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> segmentsList = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        if (!isValid(points))
            throw new IllegalArgumentException("points array is not valid");

        for (Point origin : points) {
            Point[] pointsCopy = points.clone();
            Arrays.sort(pointsCopy, origin.slopeOrder());
            ArrayList<Point> slopePoints = new ArrayList<>();
            double previousSlope = Double.NEGATIVE_INFINITY;

            for (int i = 1; i < pointsCopy.length; i++) {
                Point currentPoint = pointsCopy[i];
                double currentSlope = origin.slopeTo(currentPoint);

                if (currentSlope == previousSlope)
                    slopePoints.add(currentPoint);
                else {
                    if (slopePoints.size() >= 3) {
                        slopePoints.add(origin);
                        Collections.sort(slopePoints);
                        int lastIndex = slopePoints.size()-1;
                        LineSegment newSegment = new LineSegment(slopePoints.get(0), slopePoints.get(lastIndex));

                        if (!segmentExists(newSegment))
                            segmentsList.add(newSegment);
                    }
                    slopePoints.clear();
                    slopePoints.add(currentPoint);
                }
                previousSlope = currentSlope;
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

    private boolean segmentExists(LineSegment segment) {
        for (LineSegment s : segmentsList)
            if (s.equals(segment))
                return true;
        return false;
    }

    public int numberOfSegments() { return segmentsList.size(); }

    public LineSegment[] segments() { return segmentsList.toArray(new LineSegment[segmentsList.size()]); }
}
