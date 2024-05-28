package Sorting.insertion;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        //int [] myNumbers = {15,70,10,5,3,57,43,47,85,83,11,22,36};
        int [] myNumbers = {3,1,2};
        for (int i = 0;i < numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("before: ");
        printArray(myNumbers);
        System.out.println("after sorting :");
        insertionSort(myNumbers);
        printArray(myNumbers);
    }

    public static void printArray(int[] numbers){
        System.out.println(" ");
        for (int number:numbers) System.out.print(number + " ");
    }

    public static  void insertionSort(int[] arr){
        for (int i = 1; i <arr.length ; i++) {

            int currentValue = arr[i]; // 2
            int j = i - 1; // 0
            while (j >= 0 && arr[j] > currentValue){
                arr[j + 1] = arr[j];
                j--; //0
                System.out.println( i +". :" + Arrays.toString(arr));
            }
            arr[j + 1] = currentValue;

        }
    }
}
