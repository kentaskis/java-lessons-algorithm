package practic;

public class Practic {
    public static void main(String[] args) {
//        int count = ;
//        System.out.println(count7(717257547));
//        System.out.println(bunnyEars(5));
//        System.out.println(countNum(1000023));
        getNumBetween(1,3);
        System.out.println();
        getNumBetween(9,3);
    }


    /*
     *     1. Дано неотрицательное значени int n, небходимо вернуть количество семерок в этом значении, например в числе 717
     *     есть 2 семерки, значит функция вернет 2. Обратите внимание, что умножение (%) на 10 дает крайнюю правую цифру
     *      (126 % 10 равно 6),
     *      в то время как деление (/) на 10 удаляет крайнюю правую цифру (126/10 равно 12).
     *
     *      Пример ответа:
     *      count7(717) → 2
     *      count7(7) → 1
     *      count7(123) → 0
     */
    public static int count7(int val) {
        if(val<1) {
            return 0;
        }
        return ((val%10 == 7)?1:0) + count7(val/10);
    }


     /*      2.У нас есть несколько кроликов, и у каждого кролика два больших висячих уха.
     *      Мы хотим вычислить общее количество ушей у всех кроликов рекурсивно (без циклов или умножения).
     * <p>
     * bunnyEars(0) → 0
     * bunnyEars(1) → 2
     * bunnyEars(2) → 4
     */
    public static int bunnyEars(int bunnyCount) {
        if(bunnyCount<1){
            return 0;
        }
        return 2+bunnyEars(bunnyCount-1);
    }
     /* 3. Сумма цифр числа
     *     Дано натуральное число N. Вычислите сумму его цифр.
     *     При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется).
     */
      public static int countNum(int number) {
          if(number<1) {
              return 0;
          }
          return number%10 + countNum(number/10);
      }

     /*     4.    От A до B
     *     Даны два целых числа A и В (каждое в отдельной строке).
     *     Выведите все числа от A до B включительно, в порядке возрастания,
     *     если A < B, или в порядке убывания в противном случае.
     */
    public static void getNumBetween(int firstNum, int secondNum) {
        System.out.print(firstNum );
        if(firstNum==secondNum) {
            return;
        }
        if(firstNum>secondNum){
            firstNum--;
        } else {
            firstNum++;
        }
        getNumBetween(firstNum,secondNum);
    }
}
