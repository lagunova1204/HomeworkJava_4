// 1. Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод(не void), который вернет “перевернутый” список.

import java.util.LinkedList;

public class Task_1 {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        System.out.println("Исходный список элементов: " + ll);

        LinkedList<Integer> reversedList = reverseLinkedList(ll);
        System.out.println("Перевернутый список: " + reversedList);

    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> ll) {

        LinkedList<Integer> reversedList = new LinkedList<>();

        for (int i = ll.size() - 1; i >= 0; i--) {

            Integer element = ll.get(i);

            reversedList.add(element);

        }

        return reversedList;

    }

}