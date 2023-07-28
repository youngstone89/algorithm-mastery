public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                { 0, 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8 },
                { 9, 10, 11 }
        };
        Search2DMatrix s = new Search2DMatrix();
        System.out.println(s.search(arr, 12));
        ;

    }

    private boolean search(int[][] arr, int target) {

        return this.find(arr, target);
    }

    private boolean find(int[][] arr, int target) {
        int rowIdx = this.binarySearchRow(arr, 0, arr.length - 1, target);
        boolean found = this.binarySearchColumn(arr[rowIdx], 0, arr[rowIdx].length - 1, target);
        return found;
    }

    private boolean binarySearchColumn(int[] arr, int low, int high, int target) {
        boolean result = false;
        if (low > high) {
            return result;
        }

        int mid = (low + high) / 2;
        if (target == arr[mid]) {
            result = true;
        } else if (target > arr[mid]) {
            result = binarySearchColumn(arr, mid + 1, high, target);
        } else if (target < arr[mid]) {
            result = binarySearchColumn(arr, low, mid - 1, target);
        }
        return result;
    }

    /*
     * find row index of array that contains target values
     */
    private int binarySearchRow(int[][] arr, int low, int high, int target) {

        int rowIdx = -1;
        int mid = (low + high) / 2;
        if (low == high) {
            rowIdx = mid;
            return rowIdx;
        }
        if (target > arr[mid][0]) {
            if (target <= arr[mid][arr[mid].length - 1]) {
                rowIdx = mid;
            } else {
                // find target again from mid+1, high, range
                rowIdx = this.binarySearchRow(arr, mid + 1, high, target);
            }

        } else if (target < arr[mid][0]) {
            // find target agin from low, mid-1
            rowIdx = this.binarySearchRow(arr, low, mid - 1, target);
        } else {
            rowIdx = mid;
        }
        return rowIdx;

    }
}
