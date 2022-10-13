package _12102022;

import java.util.Arrays;

public class Tasks {
    // 1 Задание
    /*
    Сложите все элементы массива между собой
     */

    // 2 Задание
    /*
    Напишите программу, которая высчитывает среднее арифметическое всех элементов в массиве
     */

    // 3 Задание
    /*
    Напишите программу, которая вставляет элемент в определенную позицию в массиве
     */

    // 4 Задание
    /*
    Напишите программу, которая находит максимальный и минимальный элемент в массиве
     */

    public static void main(String[] args) {
        int[] array = {3, 55, 44, 22, 77};
        System.out.println("sum=" + getSum(array));
        System.out.println("avg=" + getAvg(array));
        System.out.println("new array: " + Arrays.toString(insertEl(array, 2, 99)));
        System.out.println("min=" + min(array));
        System.out.println("max=" + max(array));
    }

    public static int getSum(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    public static float getAvg(int[] array) {
        return (float) getSum(array) / array.length;
    }

    public static int[] insertEl(int[] array, int position, int value) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (i >= position && i != 0) {
                array[i] = array[i - 1];
            }
            if (i == position) {
                array[i] = value;
            }
        }

        return array;
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
