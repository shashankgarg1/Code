import java.util.Deque;
import java.util.LinkedList;
import java.util.Collection;

class MaxKSubArray {
    public Deque<Integer> dequeue;

    public MaxKSubArray() {
        dequeue = new LinkedList<Integer>();
    }

    private void printMaxKSubArray(int[] arr, int k) {
        int i = 0;
        for (; i < k; i++) {
            while (!dequeue.isEmpty() && arr[dequeue.peekLast()] < arr[i])
                dequeue.removeLast();
            dequeue.addLast(i);
        }

        for (; i < arr.length; i++) {
            System.out.println(arr[dequeue.peekFirst()]);
            while (!dequeue.isEmpty() && dequeue.peekFirst() <= i - k)
                dequeue.removeFirst();
            
            while (!dequeue.isEmpty() && arr[dequeue.peekLast()] < arr[i])
                dequeue.removeLast();
            dequeue.addLast(i);
        }

        System.out.println(arr[dequeue.peekFirst()]);
    }
    public static void main(String[] args) {
        int arr[]={12, 1, 78, 90, 57, 89, 56};
        int k=3;
        (new MaxKSubArray()).printMaxKSubArray(arr, k);
    }
}