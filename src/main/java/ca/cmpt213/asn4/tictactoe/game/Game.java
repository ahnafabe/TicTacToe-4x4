/**
 * The Game class represents the logic and state of a Tic-Tac-Toe game on a 4x4 board.
 * It handles player moves, checks for victories, draws, and provides methods for resetting the game.
 *
 * <p>The game board is represented by a 2D array, where each cell can be occupied by player 1, player 2,
 * or remain unoccupied. Players take turns making moves, and the game continues until one player wins
 * or the board is filled, resulting in a draw.</p>
 *
 * <p>The class provides methods such as {@link #makeMove(int, int)}, {@link #isGameWon()},
 * {@link #isGameDraw()}, and {@link #reset()} to interact with the game state.</p>
 *
 * <p>Player moves are indicated by their respective player numbers (1 or 2), and the class ensures
 * the correctness of moves and the determination of game outcomes.</p>
 *
 * <p>Internally, the class uses methods like {@link #checkRows()}, {@link #checkColumns()}, and
 * {@link #checkDiagonals()} to evaluate the win conditions based on the current state of the board.</p>
 *
 * <p>This class follows a simple logic for a standard Tic-Tac-Toe game with additional features for
 * a 4x4 board, enabling a full-fledged game experience.</p>
 *
 * @author Ahnaf Abeyed
 * @version 1.0
 * @see java.lang.Object
 */

package ca.cmpt213.asn4.tictactoe.game;

public class Game {
    private final int[][] board;
    private int currentPlayer;

    public Game() {
        board = new int[4][4];
        currentPlayer = 1; // Assuming player 1 starts
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col] == 0) {
            board[row][col] = currentPlayer;
            currentPlayer = 3 - currentPlayer; // Switch player (1 <-> 2)
            System.out.println("Player " + currentPlayer + " made a move at (" + row + ", " + col + ")");
            return true;
        }
        return false;
    }

    public boolean isGameWon() {
        // Check for a win
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int row = 0; row < 4; row++) {
            int count = 0;
            int player = board[row][0];

            for (int col = 0; col < 4; col++) {
                if (board[row][col] == player && player != 0) {
                    count++;
                } else {
                    count = 1;
                    player = board[row][col];
                }

                if (count == 4) {
                    return true; // Four consecutive cells with the same player's mark
                }
            }
        }

        return false;
    }

    private boolean checkColumns() {
        for (int col = 0; col < 4; col++) {
            int count = 0;
            int player = board[0][col];

            for (int row = 0; row < 4; row++) {
                if (board[row][col] == player && player != 0) {
                    count++;
                } else {
                    count = 1;
                    player = board[row][col];
                }

                if (count == 4) {
                    return true; // Four consecutive cells with the same player's mark
                }
            }
        }

        return false;
    }

    private boolean checkDiagonals() {
        // Check the main diagonal
        int countMainDiagonal = 0;
        int playerMainDiagonal = board[0][0];

        for (int i = 0; i < 4; i++) {
            if (board[i][i] == playerMainDiagonal && playerMainDiagonal != 0) {
                countMainDiagonal++;
            } else {
                countMainDiagonal = 1;
                playerMainDiagonal = board[i][i];
            }

            if (countMainDiagonal == 4) {
                return true; // Four consecutive cells with the same player's mark on the main diagonal
            }
        }

        // Check the anti-diagonal
        int countAntiDiagonal = 0;
        int playerAntiDiagonal = board[0][3];

        for (int i = 0; i < 4; i++) {
            if (board[i][3 - i] == playerAntiDiagonal && playerAntiDiagonal != 0) {
                countAntiDiagonal++;
            } else {
                countAntiDiagonal = 1;
                playerAntiDiagonal = board[i][3 - i];
            }

            if (countAntiDiagonal == 4) {
                return true; // Four consecutive cells with the same player's mark on the anti-diagonal
            }
        }

        return false;
    }

    public boolean isGameDraw() {
        // Check for a draw
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == 0) {
                    return false; // If there is an empty cell, the game is not a draw
                }
            }
        }
        return true; // All cells are filled, and no one has won, so it's a draw
    }

    public int getPlayerAt(int row, int col) {
        return board[row][col];
    }

    public void reset() {
        // Reset the game state
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col] = 0;
            }
        }
        currentPlayer = 1;
    }

}
