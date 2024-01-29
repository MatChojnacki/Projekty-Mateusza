package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsGame {

    private int playerWins;
    private int computerWins;
    private int roundsToWin;
    private boolean endGame;

    public RpsGame(int roundsToWin) {
        this.roundsToWin = roundsToWin;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (!endGame) {
            System.out.println("Wybierz swój ruch:");
            System.out.println("1 - Kamień");
            System.out.println("2 - Papier");
            System.out.println("3 - Nożyce");
            System.out.println("x - Zakończ grę");
            System.out.println("n - Rozpocznij nową grę");

            String playerMove = scanner.nextLine();

            if (playerMove.equals("x")) {
                endGameConfirmation(scanner);
            } else if (playerMove.equals("n")) {
                endCurrentGameConfirmation(scanner);
            } else if (playerMove.equals("1") || playerMove.equals("2") || playerMove.equals("3")) {
                int computerMove = random.nextInt(3) + 1;
                int playerMoveInt = Integer.parseInt(playerMove);

                displayRoundResult(playerMoveInt, computerMove);
                displayCurrentScore();
                checkGameEnd();
            } else {
                System.out.println("Niepoprawny wybór. Spróbuj jeszcze raz.");
            }
        }

        scanner.close();
    }

    private void displayRoundResult(int playerMove, int computerMove) {
        System.out.println("Twój ruch: " + moveToString(playerMove));
        System.out.println("Ruch komputera: " + moveToString(computerMove));

        if (playerMove == computerMove) {
            System.out.println("Remis w tej rundzie!");
        } else if ((playerMove == 1 && computerMove == 3) ||
                (playerMove == 2 && computerMove == 1) ||
                (playerMove == 3 && computerMove == 2)) {
            System.out.println("Wygrałeś rundę!");
            playerWins++;
        } else {
            System.out.println("Przegrałeś rundę!");
            computerWins++;
        }
    }

    private void displayCurrentScore() {
        System.out.println("Wynik gry: " + playerWins + " - " + computerWins);
    }

    private void checkGameEnd() {
        if (playerWins == roundsToWin || computerWins == roundsToWin) {
            endGame = true;
            displayGameResult();
            endCurrentGameConfirmation(new Scanner(System.in));
        }
    }

    private void displayGameResult() {
        if (playerWins > computerWins) {
            System.out.println("Gratulacje! Wygrałeś grę!");
        } else {
            System.out.println("Niestety, przegrałeś grę. Spróbuj ponownie!");
        }
    }

    private void endGameConfirmation(Scanner scanner) {
        System.out.println("Czy na pewno chcesz zakończyć grę? (t/n)");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("t")) {
            endGame = true;
            displayGameResult();
        }
    }

    private void endCurrentGameConfirmation(Scanner scanner) {
        System.out.println("Czy na pewno chcesz zakończyć aktualną grę? (t/n)");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("t")) {
            endGame = true;
        }
        else {
            endGame = false;
        }
    }

    private String moveToString(int move) {
        switch (move) {
            case 1:
                return "Kamień";
            case 2:
                return "Papier";
            case 3:
                return "Nożyce";
            default:
                return "Nieznany ruch";
        }
    }
}