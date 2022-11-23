package practic;

import java.util.Arrays;
import java.util.Stack;

public class MergeSort {

    private static int count = 0;
    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 87, 1, 0, 52, 42, 41, 1, 5, 7};
        // исходя из подсчетов сложность примерно O(n*log n)
        System.out.println(Arrays.toString(mergeSortIterative(arr)));
        System.out.println("count=" + count);
        count = 0;

        int[] arr2 = new int[]{2, 6, 87, 1, 0, 52, 42, 41, 1, 5, 7};
        // исходя из подсчетов сложность O(n2)
        mergeSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
        System.out.println("count=" + count);

    }

    //    Переписать метод mergeSort через цикл (без рекурсии)
    static int[] mergeSortIterative(int[] arr) {
        Stack<int[]> stack1 = new Stack<>();
        Stack<int[]> stack2 = new Stack<>();

        for (int j : arr) {
            count++;
            stack1.push(new int[]{j});
        }
        while (stack1.size() > 1) {
            while (stack1.size() > 1) {
                count++;
                int[] first = stack1.pop();
                int[] second = stack1.pop();
                int[] mergedArr = mergeArr(first, second);
                stack2.push(mergedArr);
            }
            while (stack2.size() > 1) {
                count++;
                int[] first = stack2.pop();
                int[] second = stack2.pop();
                int[] mergedArray = mergeArr(first, second);
                stack1.push(mergedArray);
            }
        }
        return stack1.isEmpty() ? stack2.pop() : stack1.pop();
    }

    private static int[] mergeArr(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int posLeft = 0, posRight = 0;
        for (int i = 0; i < res.length; i++) {
            count++;
            if (posLeft == (left.length)) {
                res[i] = right[posRight];
                posRight++;
                continue;
            }
            if (posRight == (right.length)) {
                res[i] = left[posLeft];
                posLeft++;
                continue;
            }
            if (left[posLeft] < right[posRight]) {
                res[i] = left[posLeft];
                posLeft++;
            } else {
                res[i] = right[posRight];
                posRight++;
            }
        }
        return res;
    }


    static void mergeSort(int[] arr, int left, int right) {
        count++;
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    static void merge(int[] arr, int left, int middle, int right) {
        int ind1 = middle - left + 1;
        int ind2 = right - middle;

        int[] arrL = new int[ind1];
        int[] arrR = new int[ind2];

        for (int i = 0; i < ind1; i++) {
            count++;
            arrL[i] = arr[i + left];
        }

        for (int i = 0; i < ind2; i++) {
            count++;
            arrR[i] = arr[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Сортируем 2 массива между собой
        while (i < ind1 && j < ind2) {
            count++;
            if (arrL[i] <= arrR[j]) {
                arr[k] = arrL[i];
                i++;
            } else {
                arr[k] = arrR[j];
                j++;
            }

            k++;
        }

        // Копируем оставшиеся элементы из arrL, если они есть
        while (i < ind1) {
            count++;
            arr[k] = arrL[i];
            i++;
            k++;
        }

        // Копируем оставшиеся элементы из arrR, если они есть
        while (j < ind2) {
            count++;
            arr[k] = arrR[j];
            j++;
            k++;
        }
    }
}