package ab12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by butkoav on 25.09.2016.
 */
public class ThreePawns {
    private static BufferedReader commandReader;
    private static Board game;

    public static void main(String... args) throws IOException {
        commandReader = new BufferedReader(new InputStreamReader(System.in));
        game = Board.startNewGame();
        game.printBoard();

        while (!game.gameOver) {
            readCommand();
        }

        commandReader.close();
    }

    private static void readCommand() {
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
            game.movePawn(command); //Players move
            System.out.println("AI: ");
            command = ThreePawnsAI.nextMove(game);
            System.out.println(command);
            game.movePawn(command, false); //AIs move
            game.printBoard();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
