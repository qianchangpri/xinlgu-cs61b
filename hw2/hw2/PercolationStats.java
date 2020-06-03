package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    public int numOfexperiments;
    public double[] fractions;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 | T <= 0) {
            throw new IllegalArgumentException();
        }
        fractions = new double[T];
        numOfexperiments = T;
        for (int i = 0; i < T; i += 1) {
            Percolation perc = pf.make(N);
            while (!perc.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                perc.open(row, col);
            }
            fractions[i] = (double) perc.numberOfOpenSites() / (N * N);
        }
    }  // perform T independent experiments on an N-by-N grid
    public double mean() {
        return StdStats.mean(fractions);
    }                                          // sample mean of percolation threshold
    public double stddev() {
        return  StdStats.stddev(fractions);
    }                                        // sample standard deviation of percolation threshold
    public double confidenceLow() {
        double mu = mean();
        double sigma = stddev();
        return mu - 1.96 * sigma / Math.sqrt(numOfexperiments);
    }                                 // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        double mu = mean();
        double sigma = stddev();
        return mu + 1.96 * sigma / Math.sqrt(numOfexperiments);
    }                                // high endpoint of 95% confidence interval

    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats perc = new PercolationStats(10, 100, pf);
        System.out.println(perc.mean());
        System.out.println(perc.stddev());
        System.out.println(perc.confidenceLow());
        System.out.println(perc.confidenceHigh());
    }
}
