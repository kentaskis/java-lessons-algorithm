package _02112022;

public class Test {
    public static void main(String[] args) {
        int[] arr = {11, 22, 44, 50, 60, 86, 114, 140, 145, 190};
        System.out.println(findVal(arr, 0, arr.length - 1, 140));
    }

    static int findVal(int[] arr, int first, int last, int search) {
        if (last >= first) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == search) {
                return mid;
            }
            if (arr[mid] > search)
                return findVal(arr, first, mid - 1, search);

            return findVal(arr, mid + 1, last, search);
        }
        return -1;
    }

}

