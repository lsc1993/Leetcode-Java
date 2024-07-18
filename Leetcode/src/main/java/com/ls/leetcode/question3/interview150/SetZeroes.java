package com.ls.leetcode.question3.interview150;

import java.util.ArrayList;
import java.util.List;

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        List<Integer> rowList = new ArrayList<>();
        List<Integer> columnList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rowList.add(i);
                    columnList.add(j);
                }
            }
        }

        for (int i = 0; i < rowList.size(); i++) {
            for (int j = 0; j < column; j++) {
                matrix[rowList.get(i)][j] = 0;
            }
        }

        for (int i = 0; i < columnList.size(); i++) {
            for (int j = 0; j < row; j++) {
                matrix[j][columnList.get(i)] = 0;
            }
        }
    }
}
