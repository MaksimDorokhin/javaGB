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
        int xStart = inputNaturalNumber("(координата входа X)", in);
        int yStart = inputNaturalNumber("(координата входа Y)", in);
        int xExit = inputNaturalNumber("(координата выхода X)", in);
        int yExit = inputNaturalNumber("(координата выхода Y)", in);
        in.close();

        MapGenerator mg = new MapGenerator();
        Point2D cat = new Point2D(xStart,yStart);
        Point2D exit = new Point2D(xExit,yExit);
        mg.setExit(exit);

        System.out.print("\nНачальная карта:\n");
        System.out.println(
                new MapPrinter().rawData(
                        mg.getMap()));

        WaveAlgorithm wave = new WaveAlgorithm(mg.getMap());
        wave.Numerize(cat);

        System.out.print("\nКарта с обходом волновым алгоритмом:\n");
        System.out.println(
                new MapPrinter().rawData(
                        mg.getMap()));

        wave.showRoad(wave.getRoad(exit));
        System.out.print("\nКарта с визуализацией пути от старта до финиша:\n");
        System.out.println(
                new MapPrinter().visualData(
                        mg.getMap()));
    }
}