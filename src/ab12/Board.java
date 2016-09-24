package ab12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 * Created by butkoav on 24.09.2016.
 */
public class Board implements Serializable {
    private static Board game;
    private int[][] board;
    private Pawn[][] pawns = new Pawn[3][2];
    private boolean gameOver = false;
    private String[] cellTypes = new String[]{"   ", " @ ", " O "};
    private static BufferedReader commandReader;

    public static void main(String... args) throws IOException {
        commandReader = new BufferedReader(new InputStreamReader(System.in));
        game = new Board();
        game.printBoard();

        while (!game.gameOver) {
            readComand();
        }

        commandReader.close();
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

    private void printBoard() {
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

    private static void readComand() throws IOException {
        System.out.println("Player: ");
        try {
            String command = commandReader.readLine();
            if (command.toLowerCase().equals("exit")) {
                game.gameOver = true;
                return;
            }
            if (command.toLowerCase().equals("help") || command.toLowerCase().equals("?")) {
                //printHelp();
                return;
            }
            game.pawns[0][0].setX(Integer.parseInt(command));
            game.draw();
            game.printBoard();
        } catch (Exception e) {
            System.out.println("Wrong command!");
        }

    }

    private enum RowTypes {
        A, B, C
    }
}
