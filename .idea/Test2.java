package CourseJava.Online;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {
        System.out.print("_________");
        System.out.println("\nПервое задание");

        int[] massive1 = {1, 0, 0, 1, 0, 1, 1, 0, 1};
        {
            for (int i = 0; i < massive1.length; i++) {
                massive1[i] = massive1[i] == 1 ? 0 : 1;
                System.out.print(massive1[i] + " ");
            }
            System.out.print("\n_________");
        }

        System.out.println("\nВторое задание");

        int[] massive2 = new int[8];
        massive2Info(massive2, 3, 1);
        System.out.println(Arrays.toString(massive2));

        System.out.print("\n_________");

        System.out.println("\nТретье задание");

        int[] numbers = {1,5,3,2,11,4,5,2,4,8,9,1};
        massive3Info(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.print("\n_________");

        System.out.println("\nЧетвёртое задание");

        int[] numbersInfo = {6, 6, 8, 12, 45, 100, 145, 220, 6, 8, 99, 3, 7};
        System.out.println(minNumber(numbersInfo));
        System.out.println(maxNumber(numbersInfo));



        }


    public static void massive2Info(int[] number, int one, int two){
        for(int i = 0; i < 8; i ++){
            number[i] = two + i * one; }
    }
    public static void massive3Info(int[] number1){
        for(int i = 0; i < number1.length; i++){
            if(number1[i] < 6){
                number1[i] *= 2;
            }
        }
    }
    public static int minNumber(int[] number3){
        int min = number3[0];
        for(int i = 0; i < number3.length; i++){
            if (min > number3[i])
                min = number3[i];
        }
        return min;
    }
    public static int maxNumber(int[] number3){
        int max = number3[0];
        for(int i = 0; i < number3.length; i++){
            if (max < number3[i])
                max = number3[i];
        }
        return max;

        }


}




