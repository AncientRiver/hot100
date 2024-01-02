package com.jh.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针获取数据
 */
public class SpiralOrder {

    public static void main(String[] args) {
        SpiralOrder order = new SpiralOrder();
//        int[][] ints = {new int[]{0, 1, 2, 0}, new int[]{3, 4, 5, 2}, new int[]{1, 3, 1, 5}};
//        int[][] ints = {new int[]{0}, new int[]{3}, new int[]{1}};
        int[][] ints = {new int[]{0,1}, new int[]{3,2}};
        System.out.println(order.spiralOrder(ints));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int rowNum = matrix.length;//行数
        int columnNum = matrix[0].length;//列数
        int[][] pathMatrix = new int[rowNum][columnNum];
        List<Integer> list = new ArrayList<>();
        rightSearch(0, 0, matrix, pathMatrix, rowNum, columnNum, list);
        return list;
    }

    public void rightSearch(int row, int column, int[][] numMatrix, int[][] pathMatrix, int rowNum, int columnNum, List<Integer> list) {
        Integer i, lastIndex = null;
        for (i = column; i < columnNum; i++) {
            //判断右侧是否可以遍历
            if (pathMatrix[row][i] == 0) {
                pathMatrix[row][i] = 1;
                list.add(numMatrix[row][i]);
                lastIndex = i;
            }
        }
        //向下搜索
        if (row + 1 < rowNum && lastIndex != null && pathMatrix[row + 1][lastIndex] != 1) {
            downSearch(row, lastIndex, numMatrix, pathMatrix, rowNum, columnNum, list);
        }
    }

    private void downSearch(int row, int column, int[][] numMatrix, int[][] pathMatrix, int rowNum, int columnNum, List<Integer> list) {
        Integer i, lastIndex = null;
        for (i = row; i < rowNum; i++) {
            //判断下侧是否可以遍历
            if (pathMatrix[i][column] == 0) {
                pathMatrix[i][column] = 1;
                list.add(numMatrix[i][column]);
                lastIndex = i;
            }
        }
        //向左搜索
        if (column - 1 >= 0 && lastIndex != null && pathMatrix[lastIndex][column - 1] != 1) {
            leftSearch(lastIndex, column, numMatrix, pathMatrix, rowNum, columnNum, list);
        }
    }

    private void leftSearch(int row, int column, int[][] numMatrix, int[][] pathMatrix, int rowNum, int columnNum, List<Integer> list) {
        Integer i, lastIndex = null;
        for (i = column; i >= 0; i--) {
            //判断左侧是否可以遍历
            if (pathMatrix[row][i] == 0) {
                pathMatrix[row][i] = 1;
                list.add(numMatrix[row][i]);
                lastIndex = i;
            }
        }
        //向上搜索
        if (row - 1 >= 0 && lastIndex != null && pathMatrix[row - 1][lastIndex] != 1) {
            upSearch(row, lastIndex, numMatrix, pathMatrix, rowNum, columnNum, list);
        }
    }

    private void upSearch(int row, int column, int[][] numMatrix, int[][] pathMatrix, int rowNum, int columnNum, List<Integer> list) {
        Integer i, lastIndex = null;
        for (i = row; i >= 0; i--) {
            //判断下侧是否可以遍历
            if (pathMatrix[i][column] == 0) {
                pathMatrix[i][column] = 1;
                list.add(numMatrix[i][column]);
                lastIndex=i;
            }
        }
        //向右搜索
        if (column + 1 < columnNum && pathMatrix[lastIndex][column + 1] != 1) {
            rightSearch(lastIndex, column, numMatrix, pathMatrix, rowNum, columnNum, list);
        }
    }
}
