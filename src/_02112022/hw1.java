package _02112022;

import java.util.ArrayList;
import java.util.List;

public class hw1 {
    public static void main(String[] args) {
        System.out.println(power(2, 3));
        System.out.println(powerFast(2, 11, 1));

        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        System.out.println(getElement(arr1, arr2, 7));

        int[] arr3 = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4};
        System.out.println(count(arr3, 2));

        int[][] arr4 = {{10, 20, 55}, {21, 30, 14}, {7, 16, 32}};
        System.out.println(getPicks(arr4));
    }

    /*
     * TODO:
     *  Даны два целых числа x и n, напишите функцию для вычисления x^n
     *      решение 1 - рекурсивно O(n)
     *      решение 2 - улучшить решение 1 до O(lon n)
     */
    static int power(int x, int n) {
        if (n == 1) {
            return x;
        }
        return x * power(x, --n);
    }

    static int powerFast(int x, int n, int res) {
        if (n <= 0) {
            return res;
        }
        if (n % 2 == 1) {
            res *= x;
        }
        return powerFast(x * x, n / 2, res);
    }

    /**
     * TODO
     *  Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент, который будет находиться на k-й позиции в конечном отсортированном массиве.
     *  Массив 1 - 100 112 256 349 770
     *  Массив 2 - 72 86 113 119 265 445 892
     *  к = 7
     *  Вывод : 256
     *  Окончательный отсортированный массив -
     *  72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
     *  7-й элемент этого массива равен 256.
     */
    static int getElement(int[] arrSizeM, int[] arrSizeN, int k) {
        List<Integer> mergeArr = new ArrayList<>();
        int m = 0, n = 0;
        for (int i = 0; i < arrSizeN.length + arrSizeM.length; i++) {
            if (arrSizeM[m] < arrSizeN[n]) {
                mergeArr.add(arrSizeM[m]);
                if (m < arrSizeM.length - 1) {
                    m++;
                }
            } else {
                mergeArr.add(arrSizeN[n]);
                if (n < arrSizeN.length - 1) {
                    n++;
                }
            }
        }
        if (k >= mergeArr.size()) {
            return -1;
        }
        return mergeArr.get(k);
    }

    /**
     * TODO
     *  Имея отсортированный массив arr[] и число x, напишите функцию, которая подсчитывает вхождения x в arr[]. Ожидаемая временная сложность O(Log n)
     *  arr[] = {1, 1, 2, 2, 2, 2, 3,}
     *  x = 2
     *  Вывод: 4 раза
     */
    static int count(int[] arr, int x) {
        return findLastNumberOfElement(arr, 0, arr.length - 1, x) - findFirstNumberOfElement(arr, 0, arr.length - 1, x) + 1;

    }

    static int findFirstNumberOfElement(int[] arr, int firstElement, int lastElement, int elementToSearch) {
        // условие прекращения
        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[mid] == elementToSearch) {
                if (arr[mid - 1] != elementToSearch) {
                    return mid;
                } else {
                    return findFirstNumberOfElement(arr, firstElement, mid - 1, elementToSearch);
                }
            }
            // если средний элемент больше целевого
            // вызываем метод рекурсивно по суженным данным
            if (arr[mid] > elementToSearch)
                return findFirstNumberOfElement(arr, firstElement, mid - 1, elementToSearch);

            // также, вызываем метод рекурсивно по суженным данным
            return findFirstNumberOfElement(arr, mid + 1, lastElement, elementToSearch);
        }
        return -1;
    }

    static int findLastNumberOfElement(int[] arr, int firstElement, int lastElement, int elementToSearch) {
        // условие прекращения
        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[mid] == elementToSearch) {
                if (arr[mid + 1] != elementToSearch) {
                    return mid;
                } else {
                    return findLastNumberOfElement(arr, mid + 1, lastElement, elementToSearch);
                }
            }
            // если средний элемент больше целевого
            // вызываем метод рекурсивно по суженным данным
            if (arr[mid] > elementToSearch)
                return findLastNumberOfElement(arr, firstElement, mid - 1, elementToSearch);

            // также, вызываем метод рекурсивно по суженным данным
            return findLastNumberOfElement(arr, mid + 1, lastElement, elementToSearch);
        }
        return -1;
    }

    /**
     * TODO
     *  Найдите пиковый элемент в двумерном массиве
     *  Элемент является пиковым, если он больше или равен своим четырем соседям слева, справа, сверху и снизу.
     *  Например, соседями для A[i][j] являются A[i-1][j], A[i+1][j], A[i][j-1] и A[i][j+1 ].
     *  Для угловых элементов отсутствующие соседи считаются отрицательными бесконечными значениями.
     *  10 20 15
     *  21 30 14
     *  7 16 32
     *  Выход: 30
     *  30 — пиковый элемент, потому что все его
     *  соседи меньше или равны ему.
     *  32 также можно выбрать в качестве пика.
     *  note
     *  * 1 Смежная диагональ не считается соседней.
     *  * 2 Пиковый элемент не обязательно является максимальным элементом.
     *  * 3 Таких элементов может быть несколько.
     *  * 4 Всегда есть пиковый элемент.
     */
    static List<Integer> getPicks(int[][] array) {
        List<Integer> picks = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int jInc = 1, iInc = 1, jDec = 1, iDec = 1;
                if (i == (array.length - 1)) {
                    iInc = 0;
                }
                if (j == (array[i].length - 1)) {
                    jInc = 0;
                }
                if (j == 0) {
                    jDec = 0;
                }
                if (i == 0) {
                    iDec = 0;
                }
                if (array[i][j] >= array[i + iInc][j] && array[i][j] >= array[i - iDec][j]
                        && array[i][j] >= array[i][j + jInc] && array[i][j] >= array[i][j - jDec]) {
                    picks.add(array[i][j]);
                }
            }
        }
        return picks;
    }
}