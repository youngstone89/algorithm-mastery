class RotateImage {

    public static void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;
        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int top = l;
                int bottom = r;

                int topLeft = matrix[top][l + i];
                matrix[top][l + i] = matrix[bottom - i][l];
                matrix[bottom - i][l] = matrix[bottom][r - i];
                matrix[bottom][r - i] = matrix[top + i][r];
                matrix[top + i][r] = topLeft;
            }
            l += 1;
            r -= 1;
        }
    }

    public static void main(String[] args) {
        /**
         * 1 2 3 4
         * 5 6 7 8
         * 9 11 12 13
         * 14 15 16 17
         * l = 0, r = 3, r-l=3
         * i = 0,1,2
         * 
         */
        int[][] matrix = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8, },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
        };
        RotateImage.rotate(matrix);
        for (int[] arr : matrix) {
            for (int e : arr) {
                System.out.print(e + "\t");
            }
            System.out.println();
        }
    }
}