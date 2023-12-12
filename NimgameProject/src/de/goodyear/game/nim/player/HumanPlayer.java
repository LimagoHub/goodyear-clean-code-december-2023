package de.goodyear.game.nim.player;

import java.util.Scanner;

public class HumanPlayer extends AbstractNimGamePlayer{
    private final Scanner scanner = new Scanner(System.in);
    public HumanPlayer() {
    }

    public HumanPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer matches) {
        System.out.println(String.format("We have %s matches. Please take 1, 2 or 3.", matches));
        int turn = scanner.nextInt();
        return turn;
    }
}
