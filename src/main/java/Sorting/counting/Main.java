package Sorting.counting;

import java.util.Arrays;

public class Main {

    //s
    public static void main(String[] args) {
       int[] result =   countingSort(new int[]{5,5,2,8,4,9,1});

        System.out.println(Arrays.toString(result));
    }

    public static int[] countingSort(int[] sort){
        //find the biggest number in the array
        int gipfel = sort[0];
        for (int i = 0; i < sort.length; i++){
            if (sort[i] > gipfel){
                gipfel = sort[i];
            }
        }
        //{5,2,8,4,9,1} gipfel  = 9

        // index      0 1 2 3 4 5 6 7 8 9
        //hilfsarray  0 0 0 0 0 1 0 0 0 0

        int [] count = new int[gipfel + 1]; // 0 0 0 0 0 0 0 0 0 0


        for (int i = 0; i < sort.length; i++){
            int x = count[sort[i]]; // count[5] = 0
            x++;// 1
            count[sort[i]] = x; // count[5] = 1
            // 0 0 0 0 0 1 0 0 0 0
        }

        //index      0 1 2 3 4 5 6 7 8 9
        //hilfsarray 0 1 1 0 1 1 0 0 1 1
        int einbauen = 0;

        for (int i = 0; i < gipfel; i++){
            for (int j = 0; j < count[i]; j++){
                sort[einbauen] = i;
                einbauen++;
            }
        }

        return  sort;
    }
}
