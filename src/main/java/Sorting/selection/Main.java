package Sorting.selection;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 4 5 1 2 3
        //------> find smallest
        Random rand = new Random();
        int[] numbers = new int[10];
        for (int i = 0;i < numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void selectionSort(int[] numbers) {
        int length = numbers.length;

        for(int i = 0; i < length - 1; i++){
                                ///i 0 1
            int min = numbers[i];//1  4  3 2
            int indexOfMin = i; //0  1  2  3
            for (int j = i + 1 ;j < length; j++){
                if (numbers[j] < min){
                    min = numbers[j];
                    indexOfMin = j;
                }
            }

            swap(numbers,i,indexOfMin);
        }

    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;

    }
}
