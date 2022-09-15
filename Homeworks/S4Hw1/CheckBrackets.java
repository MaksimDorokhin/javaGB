/*
*+Написать программу, определяющую правильность расстановки скобок в выражении.
Пример 1: a+(d*3) - истина
Пример 2: [a+(1*3) - ложь
Пример 3: [6+(3*3)] - истина
Пример 4: {a}[+]{(d*3)} - истина
Пример 5: <{a}+{(d*3)}> - истина
Пример 6: {a+]}{(d*3)} - ложь
 */
package Homeworks.S4Hw1;

import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets {

    static void checkBrackets(Character bracket, Stack<Character> brackets) {

      if (brackets.isEmpty()) {
          System.out.println("Выражение не валидно!");
          brackets.push('E');
      }
      else if (!brackets.isEmpty() && brackets.peek() != bracket) {
            System.out.printf("Выражение не валидно!");
            brackets.push('E');
      }
      else if (!brackets.isEmpty() && brackets.peek() == bracket)
            brackets.pop();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение для проверки расстановки скобок. " +
                "Можно использовать знаки (), [], {}, <>!");
        String expression = in.nextLine();
        in.close();
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

                    switch (expression.charAt(i)) {
                        case '(', '{', '[', '<' ->  brackets.push((expression.charAt(i)));
                        case ')' -> checkBrackets('(', brackets);
                        case ']' -> checkBrackets('[', brackets);
                        case '}' -> checkBrackets('{', brackets);
                        case '>' -> checkBrackets('<', brackets);
                    }
            if (!brackets.isEmpty() && brackets.peek() == 'E')
                break;

            if (i == expression.length() - 1) {
                if (brackets.isEmpty())
                    System.out.println("Скобки в выражении расставлены правильно!");
                else
                    System.out.println("В выражении имеются лишние открывающиеся скобки!");
            }
        }
    }
}

