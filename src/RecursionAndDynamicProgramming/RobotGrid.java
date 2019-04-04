package RecursionAndDynamicProgramming;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RobotGrid {

    public static void main(String[] args) {
//        boolean[][] maze = new boolean[][]{
//                {true, true, false, true, true},
//                {true, true, true, false, true},
//                {true, true, true, true, true},
//                {true, true, true, true, true},
//                {true, true, false, true, true},
//        };

        boolean[][] maze = new boolean[][]{
                {true, true, true},
                {true, false, true},
                {true, false, true},
        };

        RobotGrid rg = new RobotGrid();
        ArrayList<Point> list = rg.getPath2(maze);
        System.out.println(list.size());
    }

    ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<Point>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin || getPath(maze, row, col - 1, path) ||
                getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }

        return false;
    }

    ArrayList<Point> getPath2(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;

        ArrayList<Point> path = new ArrayList<>();
        HashMap<Point, Boolean> cache = new HashMap<>();
        int lastRow = maze.length - 1;
        int lastCol = maze[0].length - 1;
        if (getPath2(maze, lastRow, lastCol, path, cache)) {
            return path;
        }
        return null;
    }

    boolean getPath2(boolean[][] maze, int row, int col, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col);

        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        boolean isAtOrigin = (row == 0) && (col == 0);
        boolean success = false;

        if (isAtOrigin || getPath2(maze, row, col - 1, path, cache) ||
                getPath2(maze, row - 1, col, path, cache)) {
            path.add(p);
            success = true;
        }

        cache.put(p, success);
        return success;
    }

    private int numWays(int m, int n) {
        int[][] ways = new int[m][n];

        // Number of ways to reach bottom right corner from last column of grid is 1
        for (int i = 0; i <= m - 1; i++) {
            ways[i][n - 1] = 1;
        }

        // Number of ways to reach bottom right from corner last row of grid is 1 too
        for (int j = 0; j <= n - 1; j++) {
            ways[m - 1][j] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                ways[i][j] = ways[i][j + 1] + ways[i + 1][j];
            }
        }

        return ways[0][0];
    }
}
