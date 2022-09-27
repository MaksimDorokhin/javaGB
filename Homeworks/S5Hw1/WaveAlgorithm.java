package Homeworks.S5Hw1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaveAlgorithm {
    int[][] map;

    public WaveAlgorithm(int[][] map) {
        this.map = map;
    }

    public void Numerize(Point2D startPoint) {
        Queue<Point2D> queue = new LinkedList<>();
        queue.add(startPoint);
        map[startPoint.x][startPoint.y] = 1;

        while (queue.size() != 0) {
            Point2D p = queue.remove();

            if (map[p.x - 1][p.y] == 0) {
                queue.add(new Point2D(p.x - 1, p.y));
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y - 1] == 0) {
                queue.add(new Point2D(p.x, p.y - 1));
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
            }
            if (map[p.x + 1][p.y] == 0) {
                queue.add(new Point2D(p.x + 1, p.y));
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y + 1] == 0) {
                queue.add(new Point2D(p.x, p.y + 1));
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
            }
        }
    }

    public ArrayList<Point2D> getRoad(Point2D exit) {
        ArrayList<Point2D> road = new ArrayList<>();

        int count = 99;
        int min = 99;

        if (map[exit.x - 1][exit.y] < min && map[exit.x - 1][exit.y] != -1) {
            min = map[exit.x - 1][exit.y];
            count = 0;
        } if (map[exit.x][exit.y - 1] < min && map[exit.x][exit.y - 1] != -1) {
            min = map[exit.x][exit.y - 1];
            count = 1;
        } if (map[exit.x + 1][exit.y] < min && map[exit.x + 1][exit.y] != -1) {
            min = map[exit.x + 1][exit.y];
            count = 2;
        } if (map[exit.x][exit.y + 1] < min && map[exit.x][exit.y + 1] != -1) {
            min = map[exit.x][exit.y + 1];
            count = 3;
        }
        switch (count) {
            case 0 -> {
                road.add(new Point2D(exit.x - 1, exit.y));
                exit.x = exit.x - 1;
            }
            case 1 -> {
                road.add(new Point2D(exit.x, exit.y - 1));
                exit.y = exit.y - 1;
            }
            case 2 -> {
                road.add(new Point2D(exit.x + 1, exit.y));
                exit.x = exit.x + 1;
            }
            case 3 -> {
                road.add(new Point2D(exit.x, exit.y + 1));
                exit.y = exit.y + 1;
            }
        }

        while (map[exit.x][exit.y] != 2) {

            if (map[exit.x - 1][exit.y] == map[exit.x][exit.y] - 1) {
                road.add(new Point2D(exit.x - 1, exit.y));
                exit.x = exit.x - 1;
            }
            else if (map[exit.x][exit.y - 1] == map[exit.x][exit.y] - 1) {
                road.add(new Point2D(exit.x, exit.y - 1));
                exit.y = exit.y - 1;
            }
            else if (map[exit.x + 1][exit.y] == map[exit.x][exit.y] - 1) {
                road.add(new Point2D(exit.x + 1, exit.y));
                exit.x = exit.x + 1;
            }
            else if (map[exit.x][exit.y + 1] == map[exit.x][exit.y] - 1) {
                road.add(new Point2D(exit.x, exit.y + 1));
                exit.y = exit.y + 1;
            }
        }
        return road;
    }

    public void showRoad(ArrayList<Point2D> road) {
        for (Point2D dot: road) {
            map[dot.getX()][dot.getY()] = 88;
        }
    }
}
