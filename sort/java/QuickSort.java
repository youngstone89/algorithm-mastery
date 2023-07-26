public class QuickSort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int smallIdx = low;
        for (int curIdx = low; curIdx < high; curIdx++) {
            if (arr[curIdx] <= pivot) {
                int temp = arr[smallIdx];
                arr[smallIdx] = arr[curIdx];
                arr[curIdx] = temp;
                smallIdx++;
            } else {
                // No Swap
            }
        }
        // put pivot to its correct position
        int temp = arr[smallIdx];
        arr[smallIdx] = pivot;
        arr[high] = temp;
        return smallIdx;
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(arr, low, high);
            sort(arr, low, pivotIdx - 1);
            sort(arr, pivotIdx + 1, high);
        }
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        qs.sort(arr);
        for (int n : arr)
            System.out.println(n);
    }
}
