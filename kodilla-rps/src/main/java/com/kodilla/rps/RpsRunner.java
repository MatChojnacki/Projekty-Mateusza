package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoje imię: ");
        String playerName = scanner.nextLine();

        System.out.println("Podaj liczbę rund: ");
        int roundsToWin = scanner.nextInt();

        RpsGame Game = new RpsGame(roundsToWin);
        Game.play();


    }


}