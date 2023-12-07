package com.saqlain.project1;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j]=' ';
            }
        }
        Scanner sc =new Scanner(System.in);
        char player='X';
        boolean gameOver=false;

        while (!gameOver) {
            if(boardFull(board)){
                System.out.println("Draw!!!");
                break;
            }else {
                printBoard(board);
                System.out.println("Player " + player + " enter : ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                if (board[r][c] == ' ') {
                    board[r][c] = player;

                    gameOver = gameOver(board, player);
                    if (gameOver) {
                        System.out.println("player " + player + " has won!");
                    }else {
                        player = (player == 'X') ? 'O' : 'X';
                    }
                }else {
                    System.out.println("Invalid move try again");
                }
            }

        }
        printBoard(board);
    }

    private static boolean boardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean gameOver(char [][] board, char player) {
        for (int row = 0; row < 3; row++) {
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
                return true;
            }
        }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if (board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " |");
            }
            System.out.println();
        }
    }
}
