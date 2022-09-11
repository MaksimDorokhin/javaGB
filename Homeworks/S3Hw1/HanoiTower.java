/*
 * Написать программу, показывающую последовательность действий для игры “Ханойская башня”.
 */

package Homeworks.S3Hw1;

import java.util.Scanner;

public class HanoiTower {

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

    private static void towerHanoi(int n, String from , String other, String to) {
        if (n == 0)
            return;
        if (n > 0)
        towerHanoi(n-1, from, to, other);
        System.out.printf("\nПереместите диск со штыря %s на штырь %s", from, to);
        towerHanoi(n-1, other, from, to);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = inputNaturalNumber("(кол-во дисков", in);
        in.close();
        towerHanoi (n,"A","B","C");
        System.out.println();
    }
    
}
