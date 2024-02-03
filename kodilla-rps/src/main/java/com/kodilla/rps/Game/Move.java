package com.kodilla.rps.Game;

public class Move {
    private int move;

    public Move(int move) {
        this.move = move;
    }

    public int getMove() {
        return move;
    }

    public String moveToString() {
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
