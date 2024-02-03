package com.kodilla.rps.Game;

public class GameRules {
    public static boolean isPlayerWin(Move playerMove, Move computerMove) {
        return (playerMove.getMove() == 1 && computerMove.getMove() == 3) ||
                (playerMove.getMove() == 2 && computerMove.getMove() == 1) ||
                (playerMove.getMove() == 3 && computerMove.getMove() == 2);
    }
}

