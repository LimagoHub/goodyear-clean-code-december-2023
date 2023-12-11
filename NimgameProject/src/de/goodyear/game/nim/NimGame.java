package de.goodyear.game.nim;

import de.goodyear.game.Game;

import java.util.Scanner;

public class NimGame implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private int matches;
    private int turn;

    public NimGame() {
        matches = 23;

    }

    @Override
    public void play() {
        while( ! isGameOver()) {
            playSingleRound();
        }
    }

    private void playSingleRound() {

        humanTurn();
        computerTurn();
    }

    private void humanTurn() {

        if(isGameOver()) return;
        executeHumanTurn();
        terminateTurn( "Human");
    }

    private void executeHumanTurn() {
        do {
            concreteHumanTurn();
        } while(thisTurnIsValid());
    }

    private boolean thisTurnIsValid() {
        if(isTurnValid()) return false;
        System.out.println("Invalid turn");
        return true;
    }


    private void concreteHumanTurn() {
        System.out.println(String.format("We have %s matches. Please take 1, 2 or 3.", matches));
        turn = scanner.nextInt();
    }

    private void computerTurn() {


        if(isGameOver()) return;

        final int turns[] = {3,1,1,2};



        turn = turns[matches % 4];
        System.out.printf("Computer takes %s matches.\n", turn);

        terminateTurn("Computer");
    }

    // Integration
    private void terminateTurn( final String player) {
        updateBoard();
        printGameoverMessageIfGameIsOver(player);
    }


    // Operation
    private void printGameoverMessageIfGameIsOver(final String player) {
        if(matches < 1) {
            System.out.println(player + " loose");
        }
    }
    // ---------------------- Implemention Swamp
    private boolean isTurnValid() {
        return turn >= 1 && turn <= 3;
    }

    private void updateBoard() {
        matches -= turn;
    }

    private boolean  isGameOver() {
        return matches < 1;
    }
}
