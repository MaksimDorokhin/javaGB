/*
 * +На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
- команда 1 (к1): увеличить в с раза, а умножается на c
- команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d
написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно
Пример 1: а = 1, b = 7, c = 2, d = 1
ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1. 
Пример 2: а = 11, b = 7, c = 2, d = 1
ответ: нет решения. 
*Подумать над тем, как сделать минимальное количество команд
 */
package Homeworks.S1Hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class RouteFromAtoB {

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

  static int[] solve(int a, int b, int c, int d) {
    int[] arr = new int[b + 1];
    arr[a] = 1;

    for (int index = a + 1; index <= b; index++) {
      if ((index % c == 0) && (index - d >= 0)) { // Добавлена доп. проверка к решению с семинара
        arr[index] = arr[index - d] + arr[index / c];
      } else if (index - d >= 0) { // для исключения выхода за диапазон массива.
        arr[index] = arr[index - d];
      } else if (index % c == 0)
      arr[index] = arr[index / c];
    }
    return arr;
  }

  static void solveRec(int a, int b, int c, int d, int[] arr, int i) {
    if (i > b)
      return;
    else if ((i % c == 0) && (i - d >= 0))
      arr[i] = arr[i - d] + arr[i / c];
    else if (i - d >= 0)
      arr[i] = arr[(i - d)];
    else if (i % c == 0)
      arr[i] = arr[i / c];

    solveRec(a, b, c, d, arr, i + 1);
  }

  static String route(int a, int b, int c, int d, int[] arr) {
    String solution = "";
    if (arr[b] == 0)
      return solution;
    else {

      while (b > a) {

        if ((b % c == 0) && (arr[b / c] != 0)) {
          b = b / c;
          solution = "k1 " + solution;
        } else if (b - d >= a) {
          b = b - d;
          solution = "k2 " + solution;
        }
      }
    }
    return solution;
  }

  static String routeRec(int a, int b, int c, int d, int[] arr) {
    String solution = "";
    if (arr[b] == 0)
      return solution;
    if (b == a)
      return solution;
    if ((b % c == 0) && (arr[b / c] != 0))
      solution = routeRec(a, (b / c), c, d, arr) + "k1 ";
    else if ((b - d >= a) && (arr[b - d] != 0))
      solution = routeRec(a, (b - d), c, d, arr) + "k2 ";
    return solution;
  }

  static void allRoutesRec(int a, int b, int c, int d, String route, ArrayList<String> routes) {
    if (b == a) {
      routes.add(route);
      return;
    } else if (a > b) {
      return;
    } else {
      allRoutesRec(a * c, b, c, d, route + "k1 ", routes);
      allRoutesRec(a + d, b, c, d, route + "k2 ", routes);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = inputNaturalNumber("a (начальное)", in);
    int b = inputNaturalNumber("b (конечное)", in);
    boolean checkC = false;
    int c = 0;

    while (!checkC) {
      c = inputNaturalNumber("c (множитель больше 1!)", in); // иначе ломается метод allRoutesRec
      if (c > 1)
        checkC = true;
      else
        System.out.println("Вы ввели неверный множитель!");
    }
    int d = inputNaturalNumber("d (инкремент)", in);
    in.close();

    if (b < a)
      System.out.println(" Решения нет!");
    else {
      int[] routesRec = new int[b + 1];
      routesRec[a] = 1;
      int index = a + 1;
      solveRec(a, b, c, d, routesRec, index);
      if (routesRec[routesRec.length - 1] == 0)
        System.out.println(" Решения нет!");
      else {
        System.out.println("\nКарта маршрутов через рекурсию:\n");

        for (int i = 0; i < routesRec.length; i++) {
          System.out.printf("В число %d -> %d маршрутов\n", i, routesRec[i]);
        }
        System.out.println("\nКарта маршрутов через цикл:\n");
        int[] routes = solve(a, b, c, d);
  
        for (int i = 0; i < routesRec.length; i++) {
          System.out.printf("В число %d -> %d маршрутов\n", i, routes[i]);
        }
        String routeString = route(a, b, c, d, routes);
        String routeRecString = routeRec(a, b, c, d, routes);
        System.out.printf("\nОдин из возможных мартшрутов (через рекурсию): \n%s", routeRecString);
        System.out.printf("\nОдин из возможных мартшрутов (через цикл): \n%s", routeString);
  
        ArrayList<String> allRoutes = new ArrayList<>();
        String route = "";
        allRoutesRec(a, b, c, d, route, allRoutes);
        route = allRoutes.get(0);

        for (int i = 0; i < allRoutes.size(); i++) {
          if (allRoutes.get(i).length() < route.length())
            route = allRoutes.get(i);
        }
        System.out.printf("\nОдин из оптимальных мартшрутов: \n%s\n\n", route);
        for (String elemString : allRoutes) {
          System.out.println(elemString);
        }
      }
    }
  }
}
