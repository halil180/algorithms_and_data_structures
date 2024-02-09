package searching.binary;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //for binary search to work at all, the values have to be IN ORDER
        int[] nums = {4,6,7,12,34,66,77,86};
        System.out.println(binarySearch(nums,66));
        System.out.println(Arrays.binarySearch(nums,66));
    }

    private static int binarySearch(int[] numbers,int numberToFind){

        int low = 0;
        int high = numbers.length - 1;

        while (low <= high){
         int middlePostion = (low + high) / 2;
         int middleNumber = numbers[middlePostion];

         if (middleNumber == numberToFind){
             return  middlePostion;
         }

            if (numberToFind < middleNumber){
                high = middlePostion - 1;
            }else{
                low = middlePostion + 1;
            }
        }
        return -1;
    }
}
