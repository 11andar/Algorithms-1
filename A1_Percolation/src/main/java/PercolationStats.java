import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {
    private static final double CONSTANT_95 = 1.96;
    private final double[] results;
    private final int numberOfTrials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1)
            throw new IllegalArgumentException("n and trials must be >= 1");

        int numberOfSites = n*n;
        results = new double[trials];
        numberOfTrials = trials;

        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);

            while (!p.percolates()) {
                int randomRow = StdRandom.uniformInt(1, n+1);
                int randomCol = StdRandom.uniformInt(1, n+1);
                p.open(randomRow, randomCol);
            }

            results[i] = (double) p.numberOfOpenSites() / numberOfSites;
        }
    }

    // sample mean of percolation threshold
    public double mean() { return StdStats.mean(results); }

    // sample standard deviation of percolation threshold
    public double stddev() { return StdStats.stddev(results); }

    // low endpoint of 95% confidence interval
    public double confidenceLo() { return mean() - (CONSTANT_95 * stddev()) / Math.sqrt(numberOfTrials); }

    // high endpoint of 95% confidence interval
    public double confidenceHi() { return mean() + (CONSTANT_95 * stddev()) / Math.sqrt(numberOfTrials); }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("You have to pass exactly 2 CLAs of type 'int'");
            return;
        }

        try {
            int gridSize = Integer.parseInt(args[0]);
            int trialsNum = Integer.parseInt(args[1]);

            PercolationStats pStats = new PercolationStats(gridSize, trialsNum);

            String confidenceInterval = "[" + pStats.confidenceLo() + ", " + pStats.confidenceHi() + "]";

            System.out.println("mean                            = " + pStats.mean());
            System.out.println("stddev                          = " + pStats.stddev());
            System.out.println("95% confidence interval         = " + confidenceInterval);

        } catch (NumberFormatException e) {
            System.out.println("Each CLA must be a parsable int");
        }
    }
}
