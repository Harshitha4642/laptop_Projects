package com.sudoku.puzzle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SudokuVerifierController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/verifySudoku")
    public String verifySudoku(@RequestParam("sudoku") String sudoku, Model model) {
        int[][] sudokuBoard = parseSudoku(sudoku);
        boolean isValid = SudokuVerifier.isValidSudoku(sudokuBoard);
        String message = isValid ? "Valid Sudoku puzzle" : "Invalid Sudoku puzzle";
        model.addAttribute("result", message);
        return "index";
    }
    
    

    private int[][] parseSudoku(String sudoku) {
        int[][] board = new int[9][9];
        String[] lines = sudoku.split("\n");
        for (int i = 0; i < 9; i++) {
            String[] rowValues = lines[i].trim().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(rowValues[j]);
            }
        }
        return board;
    }
}

