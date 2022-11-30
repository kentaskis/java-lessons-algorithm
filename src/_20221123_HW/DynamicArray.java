package _20221123_HW;

import java.util.Arrays;

public class DynamicArray implements Dynamic {

    private int[] array;
    private int lastIndex = 0;

    private int capacity = 10;

    public DynamicArray() {
        array = new int[capacity];
    }

    // Конструктор с заданным начальным размером массива
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    // Добавление элемента в конец массива
    @Override
    public void add(int value) {
        if (lastIndex == array.length) {
            growSize();
        }
        array[lastIndex] = value;
        lastIndex++;
    }

    // Добавление элемента по индексу
    @Override
    public void addAt(int index, int value) {
        while (index >= array.length) {
            growSize();
        }
        array[index] = value;
        lastIndex = index;
    }

    // Удаление последнего элемента
    @Override
    public void remove() {
        array[lastIndex] = 0;
        lastIndex--;
        reindexLastIndex();
    }

    // Удаление элемента по индексу
    @Override
    public void removeAt(int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[lastIndex] = 0;
        lastIndex--;
        reindexLastIndex();
    }

    // Увеличивает размер массива. Вызывается когда нужно добавить элемент на позицию, больше, чем размер массива
    private void growSize() {
        array = Arrays.copyOf(array, array.length + capacity);
    }

    // Уменьшает размер массива до количества элементов
    @Override
    public void shrinkSize() {
        array = Arrays.copyOf(array, lastIndex + 1);
    }

    // Записывает новое значение в массив по индексу
    @Override
    public void set(int index, int value) {
        if (index > lastIndex) {
            throw new RuntimeException("Index " + index + " out of bounds for array length " + lastIndex);
        }
        array[index] = value;
    }

    // Получение элемента по индексу
    @Override
    public int get(int index) {
        if (index > lastIndex) {
            throw new RuntimeException("Index " + index + " out of bounds for array length " + lastIndex);
        }
        return array[index];
    }

    // Удаление всех элементов из массива (массив меняет свое значение на дефолтное)
    @Override
    public void clear() {
        array = new int[capacity];
    }

    // Проверяет, есть ли данный элемент в массиве
    @Override
    public boolean contains(int value) {
        for (int el : array) {
            if (el == value) {
                return true;
            }
        }
        return false;
    }

    // Проверяет, является ли массив пустым
    @Override
    public boolean isEmpty() {
        return lastIndex == 0;
    }

    private void reindexLastIndex() {
        for (int i = lastIndex; i > 0; i--) {
            if (array[lastIndex] == 0) {
                lastIndex--;
            } else {
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "array=" + Arrays.toString(array) +
                ", lastIndex=" + lastIndex +
                ", capacity=" + capacity +
                '}';
    }
}