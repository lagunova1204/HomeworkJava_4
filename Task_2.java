// 2. Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Task_2 {
    public static Deque<Object> fillList() {
        Deque<Object> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        return list;
    }

    public static void printList(Deque<Object> list) {
        System.out.println("Cписок элементов:\n " + list);
    }

    public static void main(String[] args) throws Exception {
        Deque<Object> que = new LinkedList<>();
        que = fillList();
        printList(que);
        System.out.println("Выберите метод реализации очереди: ");
        System.out.println("1: enqueue - помещает элемент в конец очереди");
        System.out.println("2: dequeue - возвращает первый элемент из очереди и удаляет его");
        System.out.println("3: first - возвращает первый элемент из очереди, не удаляя");
        System.out.println("4 - Завершение программы");

        while (true) {
            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            if (cmd == 1) {
                enqueue(que);
                printList(que);
                continue;
            }
            if (cmd == 2) {
                System.out.println("Первый элемент списка будет удален: " + dequeue(que));
                printList(que);
                continue;
            }
            if (cmd == 3) {
                System.out.println("Первый элемент списка: " + first(que));
                continue;
            }
            if (cmd == 4)
                break;
            else {
                System.out.println("Для выхода из программы введите 4");
            }
            sc.close();
        }

    }

    public static void enqueue(Deque<Object> list) throws Exception {
        System.out.println("Введите элемент, который надо добавить: ");
        try (Scanner sc1 = new Scanner(System.in)) {
            Object element = sc1.nextLine();
            list.addLast(element);
            sc1.close();
            
        }
    }

    public static Object dequeue(Deque<Object> list) {
        Object item = list.pollFirst();
        return item;
    }

    public static Object first(Deque<Object> list) {
        return list.peekFirst();
    }

}
