package _20221123_HW;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DynamicArray dArray = new DynamicArray(5);
        System.out.println("isEmpty: " + dArray.isEmpty());
        System.out.println(dArray);

        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            dArray.add(rnd.nextInt(99));
        }
        System.out.println(dArray);
        dArray.add(111);
        System.out.println(dArray);
        dArray.addAt(15, 222);
        System.out.println(dArray);
        System.out.println("isEmpty: " + dArray.isEmpty());
        System.out.println("array[13] = " + dArray.get(3));
        System.out.println("Array contains 111 : " + dArray.contains(111));
        dArray.remove();
        System.out.println(dArray);
        dArray.removeAt(2);
        System.out.println(dArray);
        dArray.shrinkSize();
        System.out.println(dArray);
        dArray.clear();
        System.out.println(dArray);

    }
}
