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
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                int[][] marked = new int[rowLength][columnLength];
                if (findWord(board, marked, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findWord(char[][] board,int[][] marked,int row, int column, char[] chars, int index) {
//        System.out.println(board[originRow][originColumn]+"==>"+board[row][column]);
        int rowLength = board.length;
        int columnLength = board[0].length;
        //如果存在相同的情况，那么将上下左右搜索
        if (board[row][column] == chars[index]) {
            marked[row][column]=1;
            //如果是最后一个，那么说明能找到
            if (index == chars.length - 1) return true;
            //不在最上方且原来的row不在上方，对上进行搜索
            if (row - 1 >= 0 && marked [row - 1][column]!=1) {
                int[][] ints = Arrays.copyOf(marked, rowLength);
                boolean flag = findWord(board, ints, row - 1, column, chars, index + 1);
                if (flag) return true;
            }
            //下
            if (row + 1 < rowLength && marked [row + 1][column]!=1) {
                int[][] ints = Arrays.copyOf(marked, rowLength);
                boolean flag = findWord(board, ints, row + 1, column, chars, index + 1);
                if (flag) return true;
            }
            //左
            if (column - 1 >= 0 && marked[row ][column-1]!=1) {
                int[][] ints = Arrays.copyOf(marked, rowLength);
                boolean flag = findWord(board, ints, row, column - 1, chars, index + 1);
                if (flag) return true;
            }
            //右
            if (column + 1 < columnLength && marked[row ][column+1]!=1) {
                int[][] ints = Arrays.copyOf(marked, rowLength);
                boolean flag = findWord(board, ints, row, column + 1, chars, index + 1);
                if (flag) return true;
            }
        }
        //如果不同，说明该搜索路径是错误的
        return false;

    }


    public static void main(String[] args) {
        char [][]board={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//        char[][] board = {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
        String str = "ABCESEEEFS";
        System.out.println(new Exist().exist(board, str));
    }
}
