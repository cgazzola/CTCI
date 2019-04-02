package RecursionAndDynamicProgramming;

import java.awt.*;
import java.util.ArrayList;

public class RobotGrid {

    public static void main(String[] args) {
//        boolean[][] maze = new boolean[][]{
//                {true, true, false, true},
//                {true, true, true, true},
//                {true, false, true, true},
//                {true, true, true, true},
//        };

        boolean[][] maze = new boolean[][]{
                {true, false, true},
                {true, true, true},
                {false, true, true},
        };

        RobotGrid rg = new RobotGrid();
        ArrayList<Point> list = rg.getPath(maze);
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
}
