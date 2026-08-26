class Solution {

    int decide(int currentCell, int i, int j, int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int live = 0;

        // Check 8 neighbors
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {

                // Don't check the current cell itself
                if (x == 0 && y == 0) {
                    continue;
                }

                int ni = i + x;
                int nj = j + y;

                // Check boundary
                if (ni >= 0 && ni < m &&
                    nj >= 0 && nj < n) {

                    // 1 and 2 both mean
                    // the cell was originally alive
                    if (board[ni][nj] == 1 ||
                        board[ni][nj] == 2) {

                        live++;
                    }
                }
            }
        }

        // Current cell is alive
        if (currentCell == 1) {

            // Fewer than 2 or greater than 3 → dies
            if (live < 2 || live > 3) {
                return 2;
            }

            // 2 or 3 → survives
            return 1;
        }

        // Current cell is dead
        // Exactly 3 live neighbors → becomes alive
        if (live == 3) {
            return 3;
        }

        // Otherwise remains dead
        return 0;
    }


    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        // First pass: decide next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int currentCell = board[i][j];

                board[i][j] = decide(
                    currentCell,
                    i,
                    j,
                    board
                );
            }
        }

        // Second pass: convert temporary values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}