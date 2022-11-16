package practic;

public class Merge {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 87, 1, 0, 52, 42, 41, 1, 5, 7};

//        mergeSort(arr, 0, arr.length - 1);
        sortArray(arr);
    }

    public static int[] sortArray(int[] arrayA) { // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arrayA.length < 2) {
            return arrayA; // возврат в рек
            // урсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int[] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);
    }

    public static int[] mergeArray(int[] arrayA, int[] arrayB) {

        int[] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length) {
                arrayC[i] = arrayB[i - positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[i - positionA];
                positionA++;
            } else if (arrayA[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayA[i - positionA];
                positionB++;
            } else {
                arrayC[i] = arrayB[i - positionB];
                positionA++;
            }
        }
        return arrayC;
    }

//    static void mergeSort(int[] arr, int left, int right) {
//        if (left < right) {
//            int middle = (left + right) / 2;
//
//            mergeSort(arr, left, middle);
//            mergeSort(arr, middle + 1, right);
//
//            merge(arr, left, middle, right);
//        }
//    }
//
//    static void merge(int[] arr, int left, int middle, int right) {
//        int ind1 = middle - left +1;
//        int ind2 = right - middle;
//
//        int[] arrL = new int[ind1];
//        int[] arrR = new int[ind2];
//
//        for (int i = 0; i < ind1; i++) {
//            arrL[i] = arr[i + 1];
//        }
//
//        for (int i = 0; i < ind2; i++) {
//            arrR[i] = arr[middle + 1 + i];
//        }
//
//        int i = 0;
//        int j = 0;
//        int k = 0;

    // Сортируем 2 массива между собой
//        while (i < ind1 && j < ind2) {
//            if(arrL[i]<arrR[j]) {
//                arr[k] = arrL[i];
//                arr[k+1] = arrR[j];
//            } else{
//                arr[k] = arrR[i];
//                arr[k+1] = arrL[j];
//            }
//            k++;
//            k++;
//            i++;
//            j++;
//        }
//
//        // Копируем оставшиеся элементы из arrL, если они есть
//        while (i < ind1) {
//
//        }
//
//        // Копируем оставшиеся элементы из arrR, если они есть
//        while (j < ind2) {
//
//        }
//}
}