// В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Task_3 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Stack<String> stack = new Stack<>();

    public static double inputNumber(String name) {
        while (true) {
            try {
                System.out.printf("Введите %s число: ", name);

                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Допустимые значения: любое число");
            }
        }
    }

    public static char inputOperator() {
        Character[] allowedOperationsArray = {'+', '-', '*', '/'};
        List<Character> allowedOperationsList = List.of(allowedOperationsArray);
        while (true) {
            try {
                System.out.print("Введите операцию(+, -, *, /): ");
                char operation = scanner.next().charAt(0);
                if (!allowedOperationsList.contains(operation)) {
                    throw new Exception();
                }

                return operation;
            } catch (Exception e) {
                System.out.printf("Допустимые значения: %s\n", allowedOperationsList);
            }
        }
    }

    public static void calculate(double num1, double num2, char operator) {
        double res;
        switch (operator) {
            case '+' -> res = num1 + num2;
            case '-' -> res = num1 - num2;
            case '*' -> res = num1 * num2;
            case '/' -> res = num1 / num2;
            default -> {
                System.out.printf("Операция %s не поддерживается", operator);
                return;
            }
        }
        String operation = String.format("%s %s %s = %s", num1, operator, num2, res);
        stack.push(operation);
        System.out.println(operation);
    }

    public static void calculator() {
        double num1, num2;
        char operator;
        num1 = inputNumber("первое");
        num2 = inputNumber("второе");
        operator = inputOperator();
        calculate(num1, num2, operator);
    }

    public static void showStack() {
        if (stack.isEmpty()) {
            System.out.println("Стек пуст!");
            return;
        }
        System.out.printf("%s\n", String.join("\n", stack));
    }

    public static void cancelLastOperation() {
        if (stack.isEmpty()) {
            System.out.println("Стек пуст!");
            return;
        }
        stack.pop();
    }

    public static void mainMenu() {
        while (true) {
            try {
                List<Integer> allowedMenuIndexes = IntStream.range(0, 4).boxed().toList();
                System.out.println("""
                        Главное меню:
                        1. Калькулятор
                        2. Вывод список операций
                        3. Отменить последнюю операцию
                        0. Выход"""
                );
                System.out.print("Введите номер меню: ");
                int menuIndex = Integer.parseInt(scanner.next());
                if (!allowedMenuIndexes.contains(menuIndex)) {
                    throw new Exception();
                }
                switch (menuIndex) {
                    case 1 -> calculator();
                    case 2 -> showStack();
                    case 3 -> cancelLastOperation();
                    default -> System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Недопустимая операция!");
            }
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }
}