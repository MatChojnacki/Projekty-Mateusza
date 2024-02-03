package com.kodilla.rps.Game;

import java.util.Random;

public class GameManager {
    private int playerWins;
    private int computerWins;
    private int roundsToWin;
    private boolean endGame;

    public GameManager(int roundsToWin) {
        this.roundsToWin = roundsToWin;
    }

    public void playGame() {
        GameInput gameInput = new GameInput();
        Random random = new Random();

        while (!endGame) {
            GameDisplay.displayMessage("Wybierz swój ruch:");
            GameDisplay.displayMessage("1 - Kamień");
            GameDisplay.displayMessage("2 - Papier");
            GameDisplay.displayMessage("3 - Nożyce");
            GameDisplay.displayMessage("x - Zakończ grę");
            GameDisplay.displayMessage("n - Rozpocznij nową grę");

            String playerMove = gameInput.getPlayerMove();

            if (playerMove.equals("x")) {
                endGameConfirmation(gameInput);
            } else if (playerMove.equals("n")) {
                endCurrentGameConfirmation(gameInput);
            } else if (playerMove.equals("1") || playerMove.equals("2") || playerMove.equals("3")) {
                int computerMove = random.nextInt(3) + 1;
                int playerMoveInt = Integer.parseInt(playerMove);

                displayRoundResult(new Move(playerMoveInt), new Move(computerMove));
                displayCurrentScore();
                checkGameEnd();
            } else {
                GameDisplay.displayMessage("Niepoprawny wybór. Spróbuj jeszcze raz.");
            }
        }
    }

    private void displayRoundResult(Move playerMove, Move computerMove) {
        GameDisplay.displayRoundResult(playerMove, computerMove);

        if (GameRules.isPlayerWin(playerMove, computerMove)) {
            playerWins++;
            GameDisplay.displayMessage("Wygrałeś rundę!");
        } else {
            computerWins++;
            GameDisplay.displayMessage("Przegrałeś rundę!");
        }
    }

    private void displayCurrentScore() {
        GameDisplay.displayCurrentScore(playerWins, computerWins);
    }

    private void checkGameEnd() {
        if (playerWins == roundsToWin || computerWins == roundsToWin) {
            endGame = true;
            GameDisplay.displayGameResult(playerWins, computerWins);
            endCurrentGameConfirmation(new GameInput());
        }
    }

    private void endGameConfirmation(GameInput gameInput) {
        GameDisplay.displayMessage("Czy na pewno chcesz zakończyć grę? (t/n)");
        String response = gameInput.getGameConfirmation();

        if (response.equals("t")) {
            endGame = true;
            GameDisplay.displayGameResult(playerWins, computerWins);
        }
    }

    private void endCurrentGameConfirmation(GameInput gameInput) {
        GameDisplay.displayMessage("Czy na pewno chcesz zakończyć aktualną grę? (t/n)");
        String response = gameInput.getGameConfirmation();

        if (response.equals("t")) {
            endGame = true;
        } else {
            endGame = false;
        }
    }
}
