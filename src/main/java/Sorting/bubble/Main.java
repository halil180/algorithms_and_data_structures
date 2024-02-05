package Sorting.bubble;

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

        bubbleSort(numbers);//bubble sort

        printArray(numbers);
    }


    public static  void bubbleSort(int[] arr){
        boolean swapped;// we start optimistically
        do{
            swapped = false;
            for (int i = 0; i < arr.length - 1 ; i++) {
                if (arr[i]  > arr[i + 1]){
                    swapped = true;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        } while (swapped);
    }

    public static void printArray(int[] numbers){
        System.out.println(" ");
        for (int number:numbers) System.out.print(number + " ");
    }

}
