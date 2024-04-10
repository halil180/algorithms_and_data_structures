package kadane;

public class Main {
    public static void main(String[] args) {
        //int[] arr = new int[]{-2, 2, 5, -11, 6};
        int[] arr = new int[]{-2, 2, -2, 3,9};
        System.out.println(kadeneAlgorithm(arr));
    }

    static int kadeneAlgorithm(int[] arr){

        int maxSum  = arr[0];// -2 2        7 7 7
        int currentSum = maxSum; // -2 2      7 -4 6

        for (int i = 1; i <arr.length; i++){
            currentSum = Math.max(arr[i] + currentSum, arr[i]);//6
            maxSum = Math.max(currentSum,maxSum);
        }

        return  maxSum;
    }

}