// selection sort repeatedly selects the smallest or largest element from the unsorted portion of the list
// and moves it to the sorted portion of the list
// TC: O(n2)
// Mem: O(1) temp
public class SelectionSort {
    public void sort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }

        int n = arr.length;
        // move starting pointer
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            // unsorted array
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // swap
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] arr = new int[] { 64, 25, 12, 22, 11 };
        ss.sort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
