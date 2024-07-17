package com.ls.leetcode.question3.interview150;

import java.util.HashMap;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int row = 9;
        int column = 9;

        int rowIndex = 0, columnIndex = 0;
        while (rowIndex <= 6 || columnIndex <= 6) {
            HashMap<Character, Integer> charMap = new HashMap<>();
            for (int i = 0 ; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char ch = board[i + rowIndex][j + columnIndex];
                    int count = charMap.getOrDefault(ch, 0);
                    if (ch != '.' && count > 0) {
                        return false;
                    }
                    charMap.put(ch, ++count);
                }
            }
            rowIndex += 3;
            if (rowIndex == 9) {
                columnIndex += 3;
                if (columnIndex < 9) {
                    rowIndex = 0;
                }
            }
        }


        for (int i = 0; i < row; i++) {
            HashMap<Character, Integer> charMap = new HashMap<>();
            for (int j = 0; j < column; j++) {
                char ch = board[i][j];
                int count = charMap.getOrDefault(ch, 0);
                if (ch != '.' && count > 0) {
                    return false;
                }
                charMap.put(ch, ++count);
            }
        }

        for (int i = 0; i < row; i++) {
            HashMap<Character, Integer> charMap = new HashMap<>();
            for (int j = 0; j < column; j++) {
                char ch = board[j][i];
                int count = charMap.getOrDefault(ch, 0);
                if (ch != '.' && count > 0) {
                    return false;
                }
                charMap.put(ch, ++count);
            }
        }

        return true;
    }
}
