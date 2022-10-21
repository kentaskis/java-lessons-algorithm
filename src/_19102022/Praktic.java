package _19102022;

import java.util.Objects;

public class Praktic {
    //Напишите программу, которая находит числовые дупликаты в массиве
    /*
    Пример:
    5 2 7 7 5
    Вывод:
    Дупликат: 5
    Дупликат: 7
     Посчитайте временную сложность вашего алгоритма
     */

    //Напишите программу, которая находит строковые дупликаты в массиве
    /*
    Пример:
    "bcd", "abd", "jude", "bcd"
    Вывод:
    Дупликат: bcd
     Посчитайте временную сложность вашего алгоритма
     */


    public static void main(String[] args) {
        int[] firstArray = {5, -1, 4, 0, 2, 7, -3};
//        printDuplicate(firstArray);

        String[] strArr = {"bcd", "abd", "jude", "bcd"};
//        printStrDuplicate(strArr);
//        printSecondMin(firstArray);
        method3(100);
    }

    static void method3(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j = j + i) {
                count++;
//                System.out.println("I am expert!");
            }
        }
        System.out.println(count);
    }

    public static void method(int n) {
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 1; j + n / 2 <= n; j++) {
                for (int k = 1; k <= n; k = k * 2) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }


    // O(log n)
    public static void printDuplicate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println(array[i]);
                }
            }
        }
    }

    // O(log n)
    public static void printStrDuplicate(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Objects.equals(array[i], array[j])) {
                    System.out.println(array[i]);
                }
            }
        }
    }


    ///  O(2n) => O(n)
    public static void printSecondMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        int secMin = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < secMin && array[i] > min) {
                secMin = array[i];
            }
        }

        System.out.println(secMin);
    }
/*
1. O(n)
2. O(n^2)
3. O(n*log(n))
*/
}
