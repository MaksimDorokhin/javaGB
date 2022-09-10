/*
 * Написать программу вычисления n-ого треугольного числа.
 */
package Homeworks.S2Hw1;

import java.util.Scanner;

public class TriangleNumber {

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

    static int triangleNumber(int number) {
        if (number == 1)
            return 1;
        else
            return (number + triangleNumber(number - 1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = inputNaturalNumber("n (для определения треугольного числа)", in);
        in.close();

        System.out.printf("\nТреугольное число для n = %d равно %d\n", number, triangleNumber(number));
    }
}
