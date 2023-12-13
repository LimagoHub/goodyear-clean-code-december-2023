package de.goodyear.game.nim.player;

public class GrandmaPlayer extends AbstractNimGamePlayer{

    public GrandmaPlayer() {
    }

    public GrandmaPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer integer) {
        int turn = (int)(Math.random() * 5 +1);
        System.out.println(getName() + " takes " + turn + " matches");
        return turn;
    }
}
