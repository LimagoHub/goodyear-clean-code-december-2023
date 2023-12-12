package de.goodyear.game.nim.player;

public class ComputerPlayer extends AbstractNimGamePlayer{

    private static final int TURNS[] = {3,1,1,2};

    public ComputerPlayer() {
    }

    public ComputerPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer matches) {
        int turn = TURNS[matches % 4];
        System.out.printf("Computer takes %s matches.\n", turn);
        return turn;
    }
}
