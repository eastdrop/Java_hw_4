/*Задание

        1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.*/

import java.util.*;


public class Task_1_LinkedList {
    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>(Arrays.asList(1, 2, 33, 4, 5, "2qwdq", "gdfgf"));
        for (int i = ll.size() -1; i >= 0; i--) {
            System.out.println(ll.get(i));
        }
        // ИЛИ ТАК
        LinkedList deque = new LinkedList();
        for (Object o : ll) {
            deque.addFirst(o);
            }
        System.out.println(deque);
    }

}

