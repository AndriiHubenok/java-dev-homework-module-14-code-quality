package gameLogic;

import board.BoardBuilder;
import moveLogic.PlayerMove;

import java.util.Scanner;

public class Game {
    private byte winner;
    private static final char[] BOX = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void startGame() {
        BoardBuilder boardBuilder = new BoardBuilder();
        GameOutput gameOutput = new GameOutput();
        Scanner scan = new Scanner(System.in);
        boolean boxAvailable = false;
        winner = 0;
        gameOutput.outputGreetings();
        boolean boxEmpty = false;
        while (true) {
            boardBuilder.buildBoard(BOX);

            if (!boxEmpty) {
                boardBuilder.resetBoard(BOX);
                boxEmpty = true;
            }

            if (isGameOver()) {
                scan.close();
                break;
            }

            PlayerMove playerMove = new PlayerMove();
            playerMove.doPlayerMove(BOX, scan);


            checkResultOfGame('X');
            if (winner == 1) {
                continue;
            }


            boxAvailable = false;
            for (int i = 0; i < 9; i++) {
                if (BOX[i] != 'X' && BOX[i] != 'O') {
                    boxAvailable = true;
                    break;
                }
            }

            if (!boxAvailable) {
                winner = 3;
                continue;
            }

            playerMove.doComputerMove(BOX);

            checkResultOfGame('O');
        }

    }

    public boolean isGameOver() {
        if (winner > 0 && winner < 4) {
            GameOutput gameOutput = new GameOutput();
            gameOutput.outputGameOver(winner);
            return true;
        }
        return false;
    }

    public void checkResultOfGame(char symbol) {
        if ((BOX[0] == symbol && BOX[1] == symbol && BOX[2] == symbol) ||
                (BOX[3] == symbol && BOX[4] == symbol && BOX[5] == symbol) ||
                (BOX[6] == symbol && BOX[7] == symbol && BOX[8] == symbol) ||
                (BOX[0] == symbol && BOX[3] == symbol && BOX[6] == symbol) ||
                (BOX[1] == symbol && BOX[4] == symbol && BOX[7] == symbol) ||
                (BOX[2] == symbol && BOX[5] == symbol && BOX[8] == symbol) ||
                (BOX[0] == symbol && BOX[4] == symbol && BOX[8] == symbol) ||
                (BOX[2] == symbol && BOX[4] == symbol && BOX[6] == symbol)) {
            if (symbol == 'X') {
                winner = 1;
            } else {
                winner = 2;
            }
        }
    }
}
