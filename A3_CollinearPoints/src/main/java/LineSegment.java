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
        p.drawTo(q);
    }

    public String toString() {
        return "(" + p.toString() + ", " + q.toString() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LineSegment that = (LineSegment) obj;
        return (p.equals(that.p) && q.equals(that.q)) || (p.equals(that.q) && q.equals(that.p));
    }

    @Override
    public int hashCode() {
        return p.hashCode() + q.hashCode();
    }
}
