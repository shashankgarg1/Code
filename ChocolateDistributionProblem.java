import java.util.Arrays;
import java.io.*;

class ChocolateDistributionProblem {
    private void findDistribution(int[] arr, int m) {
        Arrays.sort(arr);
        int startIndex = -1;
        int endIndex = -1;
        int minDifference = -1;
        
        if (arr.length < m) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < arr.length - m + 1; i++)
            if (minDifference == -1 || arr[i + m - 1] - arr[i] < minDifference) {
                startIndex = i;
                endIndex = i + m - 1;
                minDifference = arr[i + m - 1] - arr[i];
            }
        
        for (int i = startIndex; i <= endIndex; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String args[]) {
        int[] arr = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;
        (new ChocolateDistributionProblem()).findDistribution(arr, m);
    }
}