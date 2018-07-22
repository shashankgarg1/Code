import java.util.Arrays;
import java.util.Collections;

class LeftSmallerRightGreater {
    private void findPivot(Integer[] arr) {
        int n = arr.length;

        int[] leftMaxArr = new int[n];
        int[] rightMinArr = new int[n];

        int leftMax = Collections.min(Arrays.asList(arr)) - 1;
        int rightMin = Collections.max(Arrays.asList(arr)) + 1;

        for (int i = 0; i < n; i++) {
            leftMaxArr[i] = leftMax;
            if (leftMax < arr[i])
                leftMax = arr[i];
        }

        for (int i = n - 1; i > 0; i--) {
            rightMinArr[i] = rightMin;
            if (rightMin > arr[i])
                rightMin = arr[i];
        }

        for (int i = 1; i < n - 1; i++)
            if (arr[i] > leftMaxArr[i] && arr[i] < rightMinArr[i]) {
                System.out.println(arr[i]);
                return;
            }
        
        System.out.println("-1");
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 3, 2, 7, 8, 9};
        (new LeftSmallerRightGreater()).findPivot(arr);
    }
}