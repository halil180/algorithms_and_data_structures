package kadane;

public class Main2 {
    public static void main(String[] args) {
         //int[] arr = new int[]{-2, 2, 5, -11, 6};
        int[] arr = new int[]{-2, 2, 5};
        int maxSum = kadeneAlgorithm(arr);
        System.out.println("Maximum sum: " + maxSum);
    }

    static int kadeneAlgorithm(int[] arr) {
        int maxSum = arr[0];// -2 2 7
        int currentSum = maxSum; // -2 2 7
        int start = 0; //1
        int end = 0; // 1 2
        int tempStart = 0; //1 1

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i] + currentSum) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum = arr[i] + currentSum;
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Print the subarray with maximum sum
        System.out.print("Subarray with maximum sum: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // for a new line

        return maxSum;
    }
}
