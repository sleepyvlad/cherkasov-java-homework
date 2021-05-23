package part01.lesson01.task02;
/*
   Задание 2, на вход N - колличество случайных чисел,
   K - шаг выбора чисел и цель попадания для целой части дробного числа
* */
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int n = 55;
        int k = 2;
        Random rand = new Random();

        try {
            int[] randomNumbers = new int[n];

            for(int i = 0; i < n; i++){
                randomNumbers[i] = rand.nextInt(100);
            }

            for(int i = k; i < n; i+=k){
                double q = Math.sqrt(randomNumbers[i]);
                if((int) q == k) {
                    System.out.println(q);
                }
            }

        } catch (NegativeArraySizeException e) {
            System.out.println("Input positive N");
            throw e;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input positive K");
            throw e;
        }
    }
}
