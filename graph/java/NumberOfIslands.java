public class NumberOfIslands {
    public static int countNumber(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
            return;
        grid[r][c] = '0'; // marked
        dfs(grid, r + 1, c); // to the botton
        dfs(grid, r, c + 1); // to the right
        dfs(grid, r - 1, c); // to the left
        dfs(grid, r, c - 1); // to the top
    }

    public static void main(String[] args) {
        char[][] islands = new char[][] {
                { '1', '1', '1', '1' },
                { '1', '1', '1', '1' },
                { '1', '1', '1', '1' },
                { '1', '1', '1', '1' },
        };
        System.out.println(countNumber(islands));

    }
}
