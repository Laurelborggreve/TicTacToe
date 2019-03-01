package com.example.assignment02;

import android.service.quicksettings.Tile;

import java.io.Serializable;

public class Game implements Serializable {

    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    private Boolean playerOneTurn; // true if player's 1's turn, false if player's 2 turn
    public int movesPlayed;
    public Boolean gameOver;

    // Initialize the board, the state of the game and the player's turn
    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i= 0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

         playerOneTurn = true;
         gameOver = false;
         movesPlayed = 0;
    }

    public TileState choose(int row, int column){
        TileState tile = board[row][column];
        if (tile == TileState.BLANK) {
            if (playerOneTurn == true) {
                board[row][column] = TileState.CROSS;
                playerOneTurn = false;
                movesPlayed++;
                return TileState.CROSS;
            }
            else {
                board[row][column] = TileState.CIRCLE;
                playerOneTurn = true;
                movesPlayed++;
                return TileState.CIRCLE;
            }
        }
        else {
            return TileState.INVALID;
        }
    }

    // The won function to check whether the game has a winner. If the game has a winner,
    // it will return the winner. Otherwise it will return a tie.
    public GameState won(){
        if (movesPlayed < 9) {
            System.out.print("The game is not finished yet");
            return GameState.IN_PROGRESS;
        }
        else if (board[0][0] == TileState.CROSS && board[1][1] == TileState.CROSS && board[2][2] == TileState.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            }
        else if (board[0][0] == TileState.CROSS && board[1][0] == TileState.CROSS && board[2][0] == TileState.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            }
        else if (board[0][0] == TileState.CROSS && board[0][1] == TileState.CROSS && board[0][2] == TileState.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            }

        else if (board[2][0] == TileState.CROSS && board[2][1] == TileState.CROSS && board[2][2] == TileState.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            }
        else if (board[0][1] == TileState.CROSS && board[1][1] == TileState.CROSS && board[2][1] == TileState.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            }
        else if (board[0][2] == TileState.CROSS && board[1][1] == TileState.CROSS && board[2][0] == TileState.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            }
        else if (board[1][0] == TileState.CROSS && board[1][1] == TileState.CROSS && board[1][2] == TileState.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            }
        else if (board[0][2] == TileState.CROSS && board[1][2] == TileState.CROSS && board[2][2] == TileState.CROSS) {
                gameOver = true;
                return GameState.PLAYER_ONE;
            }
        else if (board[0][0] == TileState.CIRCLE && board[1][1] == TileState.CIRCLE && board[2][2] == TileState.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        else if (board[0][0] == TileState.CIRCLE && board[1][0] == TileState.CIRCLE && board[2][0] == TileState.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        else if (board[0][0] == TileState.CIRCLE && board[0][1] == TileState.CIRCLE && board[0][2] == TileState.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        else if (board[2][0] == TileState.CIRCLE && board[2][1] == TileState.CIRCLE && board[2][2] == TileState.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        else if (board[0][1] == TileState.CIRCLE && board[1][1] == TileState.CIRCLE && board[2][1] == TileState.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        else if (board[0][2] == TileState.CIRCLE && board[1][1] == TileState.CIRCLE && board[2][0] == TileState.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        else if (board[1][0] == TileState.CIRCLE && board[1][1] == TileState.CIRCLE && board[1][2] == TileState.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        else if (board[0][2] == TileState.CIRCLE && board[1][2] == TileState.CIRCLE && board[2][2] == TileState.CIRCLE) {
                gameOver = true;
                return GameState.PLAYER_TWO;
            }
        else {
                System.out.print("It's a tie! \n");
                gameOver = true;
                return GameState.DRAW;
            }
        }

    // The getState function returns the current state of each tile
    public TileState getTileState(int row, int column){
        return board[row][column];
    }

}

