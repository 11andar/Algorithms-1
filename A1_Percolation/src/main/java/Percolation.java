import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;


public class Percolation {
    private final boolean[][] sites;
    private final int virtualTopIndex;
    private final int virtualBottomIndex;
    private final WeightedQuickUnionUF percolation;
    private final WeightedQuickUnionUF fullness;
    private final int rowSize;
    private final int size;
    private int openSitesCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1)
            throw new IllegalArgumentException("n can't be less than 1");

        int bottomLeftCorner = n * n - n;
        sites = new boolean[n][n];
        virtualTopIndex = 0;
        virtualBottomIndex = n*n + 1;
        percolation = new WeightedQuickUnionUF(n*n+2);
        fullness = new WeightedQuickUnionUF(n*n+1);
        rowSize = n;
        size = n*n;
        openSitesCount = 0;

        // initialize each site to blocked
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sites[i][j] = false;

        // create virtual top and virtual bottom for percolation
        for (int i = 0; i < n; i++) {
            percolation.union(i, virtualTopIndex);
            percolation.union(bottomLeftCorner + i, virtualBottomIndex);
        }

        // crate virtual top for fullness
        for (int i = 0; i < n; i++)
            fullness.union(i, virtualTopIndex);
    }

    // validates given index
    private boolean isIndexValid(int index) {
        return 1 <= index && index <= rowSize;
    }

    private void validateIndices(int row, int col) {
        if (!isIndexValid(row) || !isIndexValid(col))
            throw new IllegalArgumentException("Invalid value of row (" + row + ")" +
                                               " or col (" + col + ")");
    }

    // converts site's row and col to 1D index
    private int convertTo1D(int row, int col) { return (row-1) * rowSize + (col-1); }

    // creates unions in percolation and fullness
    private void updatePF(int p, int q) {
        percolation.union(p, q);
        fullness.union(p, q);
    }

    // opens the site (row, col) if it is not open already
    // and connects with opened neighbours
    public void open(int row, int col) {
        validateIndices(row, col);
        int sitesRow = row-1;
        int sitesCol = col-1;

        if(!isOpen(row, col)) {
            sites[sitesRow][sitesCol] = true;
            openSitesCount++;

            int siteCurrent = convertTo1D(row, col);

            if (row > 1 && isOpen(row-1, col)) {
                int siteAbove = convertTo1D(row-1, col);
                updatePF(siteCurrent, siteAbove);
            }

            if (col < rowSize && isOpen(row, col+1)) {
                int siteRight = convertTo1D(row, col+1);
                updatePF(siteCurrent, siteRight);
            }

            if (row < rowSize && isOpen(row+1, col)) {
                int siteBelow = convertTo1D(row+1, col);
                updatePF(siteCurrent, siteBelow);
            }

            if (col > 1 && isOpen(row, col-1)) {
                int siteLeft = convertTo1D(row, col - 1);
                updatePF(siteCurrent, siteLeft);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateIndices(row, col);
        return sites[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateIndices(row, col);

        if (!isOpen(row, col)) return false;

        if (row == 1) return true;

        int index = convertTo1D(row, col);

        return fullness.find(virtualTopIndex) == fullness.find(index);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {}

    // does the system percolate?
    public boolean percolates() {}

    // test client (optional)
    public static void main(String[] args) {}
}