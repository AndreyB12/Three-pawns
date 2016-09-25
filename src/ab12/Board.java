package ab12;

import java.io.Serializable;

/**
 * Created by butkoav on 24.09.2016.
 */
public class Board implements Serializable {

    private int[][] board;
    private Pawn[][] pawns = new Pawn[3][2];
    public boolean gameOver = false;
    private String[] cellTypes = new String[]{"   ", " @ ", " O "};

    public static Board startNewGame() {
        return new Board();
    }

    private Board() {
        pawns[0][0] = new Pawn(1, 1);
        pawns[1][0] = new Pawn(2, 2);
        pawns[2][0] = new Pawn(3, 3);
        pawns[0][1] = new Pawn(8, 1);
        pawns[1][1] = new Pawn(7, 2);
        pawns[2][1] = new Pawn(6, 3);
        draw();
    }

    private void draw() {
        board = new int[3][8];
        for (int i = 0; i < pawns[0].length; i++) {
            for (int j = 0; j < pawns.length; j++) {
                board[pawns[j][i].getY() - 1][pawns[j][i].getX() - 1] = i + 1;
            }
        }
    }

    public void printBoard() {
        draw();
        System.out.println("    1   2   3   4   5   6   7   8  ");
        System.out.println("   -------------------------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print(RowTypes.values()[i] + " |");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(cellTypes[board[i][j]]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("   -------------------------------");
        }

        System.out.println();
        System.out.println();
    }

    private enum RowTypes {
        A, B, C
    }

    public void movePawn(String newPlace) throws Exception {
        try {
            char[] coord = newPlace.toCharArray();
            pawns[RowTypes.valueOf(String.valueOf(coord[0]).toUpperCase()).ordinal()][0].setX(Integer.parseInt(String.valueOf(coord[1])));
        } catch (Exception e) {
            throw new Exception("Invalid move");
        }
    }
}
