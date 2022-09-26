// Реализовать волновой алгоритм

package Homeworks.S5Hw1;

import java.util.*;


public class WaveAlgorythm {

    static int inputNaturalNumber(String name, Scanner in) {
        int number = 0;
        boolean checkNegative = false;

        while (!checkNegative) {
            System.out.printf("Введите натуральное число %s: ", name);

            while (!in.hasNextInt()) {
                System.out.println("Вы ввели не число, повторите ввод!");
                in.next();
            }
            number = in.nextInt();

            if (number <= 0)
                System.out.println("Вы ввели не натуральное число, повторите ввод!");
            else
                checkNegative = true;
        }
        return number;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int xStart = inputNaturalNumber("(координата входа X", in);
        int yStart = inputNaturalNumber("(координата входа Y", in);
        int xExit = inputNaturalNumber("(координата выхода X", in);
        int yExit = inputNaturalNumber("(координата выхода Y", in);
        in.close();

        MapGenerator mg = new MapGenerator();
        Point2D cat = new Point2D(xStart,yStart);
        Point2D exit = new Point2D(xExit,yExit);
        mg.setExit(exit);
        System.out.println(
                new MapPrinter().rawData(
                        mg.getMap()));

        WaveAlgorithm wave = new WaveAlgorithm(mg.getMap());
        wave.Numerize(cat);

        System.out.println(
                new MapPrinter().rawData(
                        mg.getMap()));

        wave.showRoad(wave.getRoad(exit));

        System.out.println(
                new MapPrinter().rawData(
                        mg.getMap()));
    }
}


class Point2D {
    int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("x: %d  y: %d", x, y);
    }
}

class MapGenerator {
    int[][] map;

    public MapGenerator() {
        int[][] map = {
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, -1, 0, -1, -1, -1, -1, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, -1, 0, -1, 0, 0, -1, 0, 0, 0, 0, -1 },
                { -1, -1, -1, 0, -1, 0, -1, 0, 0, -1, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, -1, 0, -1, 0, 0, -1, -1, -1, 0, 0, -1 },
                { -1, 0, 0, 0, -1, 0, 0, 0, 0, -1, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, -1, 0, 0, 0, 0, -1, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };

        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }

    public void setCat(Point2D pos) {
        map[pos.x][pos.y] = -2;
    }

    public void setExit(Point2D pos) {
        map[pos.x][pos.y] = -3;
    }
}

class MapPrinter {

    public MapPrinter() {
    }

    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%5d", map[row][col]));
            }
            sb.append("\n");
        }
        sb.append("\n".repeat(3));

        return sb.toString();
    }
}

class WaveAlgorithm {
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
        } if (map[exit.x][exit.y - 1] < min && map[exit.x - 1][exit.y] != -1) {
            min = map[exit.x][exit.y - 1];
            count = 1;
        } if (map[exit.x + 1][exit.y] < min && map[exit.x - 1][exit.y] != -1) {
            min = map[exit.x + 1][exit.y];
            count = 2;
        } if (map[exit.x][exit.y + 1] < min && map[exit.x - 1][exit.y] != -1) {
            min = map[exit.x][exit.y + 1];
            count = 3;
        }
        switch (count) {
            case 0: {
                road.add(new Point2D(exit.x - 1, exit.y));
                exit.x = exit.x - 1;
            } case 1: {
                road.add(new Point2D(exit.x, exit.y - 1));
                exit.y = exit.y - 1;
            } case 2: {
                road.add(new Point2D(exit.x + 1, exit.y));
                exit.x = exit.x + 1;
            } case 3: {
                road.add(new Point2D(exit.x, exit.y + 1));
                exit.y = exit.y + 1;
            }
        }

        while (map[exit.x][exit.y] != 1) {

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