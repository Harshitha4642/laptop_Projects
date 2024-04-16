package com.sudoku.puzzle;


public class SudokuVerifier {

    public static boolean isValidSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidSubgrid(board, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidRow(int[][] board, int row) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            int num = board[row][i];
            if (num != 0) {
                if (used[num - 1]) {
                    return false;
                }
                used[num - 1] = true;
            }
        }
        return true;
    }

    private static boolean isValidColumn(int[][] board, int col) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            int num = board[i][col];
            if (num != 0) {
                if (used[num - 1]) {
                    return false;
                }
                used[num - 1] = true;
            }
        }
        return true;
    }

    private static boolean isValidSubgrid(int[][] board, int subgrid) {
        boolean[] used = new boolean[9];
        int rowOffset = (subgrid / 3) * 3;
        int colOffset = (subgrid % 3) * 3;
        for (int i = rowOffset; i < rowOffset + 3; i++) {
            for (int j = colOffset; j < colOffset + 3; j++) {
                int num = board[i][j];
                if (num != 0) {
                    if (used[num - 1]) {
                        return false;
                    }
                    used[num - 1] = true;
                }
            }
        }
        return true;
    }
}
