package Sorting.insertion;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        for (int i = 0;i < numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("before: ");
        printArray(numbers);
        System.out.println("after sorting :");
        insertionSort(numbers);
        printArray(numbers);
    }

    public static void printArray(int[] numbers){
        System.out.println(" ");
        for (int number:numbers) System.out.print(number + " ");
    }

    public static  void insertionSort(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int currentValue = arr[i];
            int j = i -1;
            while (j >= 0 && arr[j] > currentValue){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currentValue;
        }
    }
}
