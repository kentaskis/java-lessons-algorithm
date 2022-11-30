package _20221130;

import java.util.Arrays;

public class DynamicArray {
    int[] arr = new int[0];

    public void add(int e) {
        // При добавлении каждого элемента увеличить размер массива на 1
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = e;
    }

    public void remove() {
        arr = Arrays.copyOf(arr, arr.length - 1);

        // При удалении каждого элемента уменьшить размер массива на 1
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    public int size() {
        return arr.length;
    }

}