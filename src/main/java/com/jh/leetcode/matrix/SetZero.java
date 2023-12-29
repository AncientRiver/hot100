package com.jh.leetcode.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 置0问题
 */
public class SetZero {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();

        int columnLength = matrix.length;//列长
        int rowLength = matrix[0].length;//行长

        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }


        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (rowSet.contains(i)||columnSet.contains(j))matrix[i][j]=0;
            }
        }

//        rowSet.forEach(rowIndex -> {
//            IntStream.range(0,rowLength).forEach(i->matrix[rowIndex][i]=0);
//        });
//        columnSet.forEach(columnIndex -> {
//            IntStream.range(0,columnLength).forEach(i->matrix[i][columnIndex]=0);
//        });
    }

    public static void main(String[] args) {
        SetZero sz = new SetZero();
        int[][] ints = {new int[]{0,1,2,0}, new int[]{3,4,5,2}, new int[]{1,3,1,5}};
        sz.setZeroes(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
