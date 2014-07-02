/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) {
            return true;
        }
        
        if(board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }   
        
        for(int j = 0; j < board.length; j++) {
            for(int i = 0; i < board[0].length; i++) {
                if(doExist(board, word, 0, j, i)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean doExist(char[][] board, String word, int index, int j, int i) {
        char c = word.charAt(index);
        if(board[j][i] == c) {
            if(index == word.length() - 1) {
                return true;
            }
            
            board[j][i] = 0;
            
            if(j > 0 && board[j-1][i] != 0 && doExist(board, word, index+1, j-1, i)) {
               return true;
            }
            if(j < board.length-1 && board[j+1][i] != 0 && doExist(board, word, index+1, j+1, i)) {
                return true;
            }
            if(i > 0 && board[j][i-1] != 0 && doExist(board, word, index+1, j, i-1)) {
                return true;
            }
            if(i < board[0].length-1 && board[j][i+1] != 0 && doExist(board, word, index+1, j, i+1)) {
                return true;
            }
            
            board[j][i] = c;
        }
        
        return false;
    }
}
