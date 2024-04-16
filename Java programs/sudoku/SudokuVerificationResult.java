package com.sudoku.puzzle;

public class SudokuVerificationResult {

    private String message;

    public SudokuVerificationResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
