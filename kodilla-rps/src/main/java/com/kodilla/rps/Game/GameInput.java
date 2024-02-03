package com.kodilla.rps.Game;

import java.util.Scanner;

public class GameInput {
    private Scanner scanner;

    public GameInput() {
        this.scanner = new Scanner(System.in);
    }

    public String getPlayerMove() {
        return scanner.nextLine();
    }

    public String getGameConfirmation() {
        return scanner.nextLine().toLowerCase();
    }
}

