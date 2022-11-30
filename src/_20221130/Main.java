package _20221130;

public class Main {
    public static void main(String[] args) {
        DynamicArray a = new DynamicArray();

        System.out.println(a.size()); // 0

        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        a.print(); //[1, 2, 3, 4]
        System.out.println(a.size()); // 4

        a.remove();
        a.remove();

        a.print();  //[1, 2]
        System.out.println(a.size()); // 2
    }
}