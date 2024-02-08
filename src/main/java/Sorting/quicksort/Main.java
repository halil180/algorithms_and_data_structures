package Sorting.quicksort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    //1 8 3 9 4 5 7 choose a pivot

    //pivot = < 7 >
    //  5431  < 7 >  89
    // < 1 > 345   7 8 <9>
    // 1345789


    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        System.out.println(Arrays.toString(numbers));

        quickSort(numbers,0,numbers.length - 1);

        System.out.println("\nAfter:");
        System.out.println(Arrays.toString(numbers));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (end <= start) return; //base case
        int pivot = partition(array,start,end);
        quickSort(array,start,pivot - 1);
        quickSort(array,pivot + 1,end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start;j <= end -1;j++){
            if (array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
         }
        //final resting place of our pivot is i + 1
        i++;

        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        //now elements to the left of our pivot should be less than of our pivot and
        //all elements to the right ouf our pivot should be greater than or equal to out pivot
        return i; //location of out pivot
    }
 }
