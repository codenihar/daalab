public class nq {

    public static void solveNQueens(int n) {
        int[][] board = new int[n][n];
        if (solve(board, 0, n)) {
            printSolution(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check the left side of the current row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solve(int[][] board, int col, int n) {
        if (col >= n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;

                if (solve(board, col + 1, n)) {
                    return true;
                }

                board[i][col] = 0; // Backtrack
            }
        }

        return false;
    }

    public static void printSolution(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8; // Change this value to solve for different board sizes
        solveNQueens(n);
    }
}