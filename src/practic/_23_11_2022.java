package practic;

import java.util.Arrays;

public class _23_11_2022 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 87, 1, 0, 52, 42, 41, 1, 5, 7};

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr) {
        int length = arr.length;

        for (int size = 2; size <= length - 1; size = size * 2) {
            for (int left = 0; left < length - 1; left += size * 2) {
                //...
                int right = left + size - 1;
                if (right > (length - 1)) {
                    right = length - 1;
                }
                merge(arr, left, left + size / 2, right);
            }
        }
    }

    static void merge(int[] arr, int left, int middle, int right) {
        int ind1 = middle - left + 1;
        int ind2 = right - middle;

        int[] arrL = new int[ind1];
        int[] arrR = new int[ind2];

        for (int i = 0; i < ind1; i++) {
            arrL[i] = arr[i + left];
        }

        for (int i = 0; i < ind2; i++) {
            arrR[i] = arr[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Сортируем 2 массива между собой
        while (i < ind1 && j < ind2) {
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
            arr[k] = arrL[i];
            i++;
            k++;
        }

        // Копируем оставшиеся элементы из arrR, если они есть
        while (j < ind2) {
            arr[k] = arrR[j];
            j++;
            k++;
        }
    }
}

