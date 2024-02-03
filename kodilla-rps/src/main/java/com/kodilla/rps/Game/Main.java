package com.kodilla.rps.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoje imię: ");
        String playerName = scanner.nextLine();

        System.out.println("Podaj liczbę rund: ");
        int roundsToWin = scanner.nextInt();

        GameManager gameManager = new GameManager(roundsToWin);
        gameManager.playGame();
    }
}
