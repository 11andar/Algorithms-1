import edu.princeton.cs.algs4.StdDraw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class BruteCollinearPoints {
    private int numberOfSegments = 0;
    private final ArrayList<LineSegment> segmentsList = new ArrayList<LineSegment>();


    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("points array can't be null");

        if (!isValid(points))
            throw new IllegalArgumentException("point can't be null");

        for (int i = 0; i < points.length-3; i++) {
            for (int j = i+1; j < points.length-2; j++) {
                for (int k = j+1; k < points.length-1; k++) {
                    for (int l = k+1; l < points.length; l++) {
                        Point p1 = points[i], p2 = points[j], p3 = points[k], p4 = points[l];

                        if (p1.slopeTo(p2) == p1.slopeTo(p3) && p1.slopeTo(p2) == p1.slopeTo(p4)) {
                            Point[] segment = {p1, p2, p3, p4};
                            Arrays.sort(segment);
                            LineSegment tempSegment = new LineSegment(segment[0], segment[3]);
                            if (!segmentsList.contains(tempSegment)) {
                                segmentsList.add(tempSegment);
                                numberOfSegments++;
                            }
                        }
                    }
                }
            }
        }

    }

    private boolean isValid(Point[] points) {
        HashSet<Point> seen = new HashSet<>();
        for (Point point : points) {
            if (!seen.add(point) || point == null)
                return false;
        }
        return true;
    }

    public int numberOfSegments() {
        return numberOfSegments;
    }

    public LineSegment[] segments() {
        return segmentsList.toArray(new LineSegment[segmentsList.size()]);
    }

    public static void main(String[] args) {
        int lowerBound = 0;
        int upperBound = 100;
        Point[] points = new Point[100];
        Random rand = new Random();

        for (int i = 0; i < points.length; i++) {
            int randX = rand.nextInt(lowerBound, upperBound);
            int randY = rand.nextInt(lowerBound, upperBound);
            points[i] = new Point(randX, randY);
        }

        BruteCollinearPoints b = new BruteCollinearPoints(points);
        System.out.println("Number of segments: " + b.numberOfSegments);

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(lowerBound, upperBound);
        StdDraw.setYscale(lowerBound, upperBound);
        StdDraw.setPenRadius(0.015);
        StdDraw.setPenColor(StdDraw.GREEN);

        for (LineSegment s : b.segments())
            s.draw();

        StdDraw.setPenColor(StdDraw.BLACK);

        for (Point point : points)
            point.draw();
        StdDraw.show();
    }
}