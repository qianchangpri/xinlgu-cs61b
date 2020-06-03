package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int len;
    private int numOfOpenSites = 0;
    private int size;
    private int virtualTop = 0;
    private int virtualBottom;
    private boolean[] openness;
    private WeightedQuickUnionUF set;
    private WeightedQuickUnionUF backwash;

    public Percolation(int N) {
        this.len = N;
        size = len * len + 2;
        virtualBottom = size - 1;
        openness = new boolean[size];
        for (int i = 0; i < size; i += 1) {
            openness[i] = false;
        }
        set = new WeightedQuickUnionUF(size);
        backwash = new WeightedQuickUnionUF(size - 1);
    }// create N-by-N grid, with all sites initially blocked

    private int xyTo1D(int row, int col) {
        return len * row  + col + 1;
    }
    public void open(int row, int col) {
        int site = xyTo1D(row, col);
        if (isOpen(row, col)) {
            return;
        }
        numOfOpenSites += 1;
        openness[site] = true;
        if (row == 0) {
            set.union(site, virtualTop);
            backwash.union(site, virtualTop);
        }
        if (row == len - 1) {
            set.union(site, virtualBottom);
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < 4; i += 1) {
            int neighborRow = row + dx[i];
            int neighborCol = col + dy[i];
            int neighbor = xyTo1D(neighborRow, neighborCol);
            if (isOpen(neighborRow, neighborCol)) {
                set.union(neighbor, site);
                backwash.union(neighbor,site);
            }
        }

    }      // open the site (row, col) if it is not open already
    public boolean isOpen(int row, int col) {
        int site = xyTo1D(row, col);
        if (row < 0 | row > len - 1 | col < 0 | col > len - 1) {
            return false;
        }
        return openness[site];
    }  // is the site (row, col) open?
    public boolean isFull(int row, int col) {
        int site = xyTo1D(row, col);
        return backwash.connected(site, virtualTop);
    } // is the site (row, col) full?
    public int numberOfOpenSites() {
        return numOfOpenSites;
    }          // number of open sites
    public boolean percolates() {
        return set.connected(virtualTop, virtualBottom);
    }             // does the system percolate?
    public static void main(String[] args) {
        Percolation perc = new Percolation(3);
        perc.open(1,2);
        perc.open(2,2);
        perc.isOpen(1,2);
        perc.isOpen(1,1);
        perc.isFull(1,1);
        perc.open(1,1);
        perc.percolates();
        perc.open(0,1);
        perc.percolates();
        perc.isFull(2,2);
    }   // use for unit testing (not required)
}
