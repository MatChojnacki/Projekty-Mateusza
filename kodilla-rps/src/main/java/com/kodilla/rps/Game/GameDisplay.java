package com.kodilla.rps.Game;

public class GameDisplay {
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayRoundResult(Move playerMove, Move computerMove) {
        GameDisplay.displayMessage("Twój ruch: " + playerMove.moveToString());
        GameDisplay.displayMessage("Ruch komputera: " + computerMove.moveToString());
    }

    public static void displayCurrentScore(int playerWins, int computerWins) {
        System.out.println("Wynik gry: " + playerWins + " - " + computerWins);
    }

    public static void displayGameResult(int playerWins, int computerWins) {
        if (playerWins > computerWins) {
            GameDisplay.displayMessage("Gratulacje! Wygrałeś grę!");
        } else {
            GameDisplay.displayMessage("Niestety, przegrałeś grę. Spróbuj ponownie!");
        }
    }
}
