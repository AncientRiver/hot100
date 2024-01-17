package com.jh.leetcode.recall;


import java.util.Arrays;

/**
 * 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        int rowLength = board.length;
        int columnLength = board[0].length;
        char[] chars = word.toCharArray();
        if (chars.length > rowLength * columnLength) return false;
        int[][] marked = new int[rowLength][columnLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                //如果首字母相同才进行查找
                if (word.charAt(0) == board[i][j]) {
                    if (word.length()==1 &&word.length()==board.length*board[0].length)return true;
                    if (findWord(board, marked, i, j, chars, 0)) {
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }

    public boolean findWord(char[][] board, int[][] marked, int row, int column, char[] chars, int index) {
        // 越界肯定不行
        if (row < 0 || column < 0 || row >= board.length || column >= board[0].length) return false;
        // 使用过了肯定不行
        if (marked[row][column] == 1) return false;
        //如果相同,标记下一个
        if (board[row][column] == chars[index]) {
            if (index==chars.length-1)return true;
            marked[row][column] = 1;
            if (findWord(board, marked, row - 1, column, chars, index + 1) ||
                    findWord(board, marked, row, column - 1, chars, index + 1) ||
                    findWord(board, marked, row + 1, column, chars, index + 1) ||
                    findWord(board, marked, row, column + 1, chars, index + 1)) {
                return true;
            }
            marked[row][column] = 0;
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] board = {{'a', 'a'}};
//        char[][] board = {{'A'}};
//        char[][] board = {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
        String str = "aa";
        System.out.println(new Exist().exist(board, str));
    }
}
