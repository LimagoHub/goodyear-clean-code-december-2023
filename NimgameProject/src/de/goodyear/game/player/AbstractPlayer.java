package de.goodyear.game.player;

public abstract class AbstractPlayer<BOARD,TURN> implements Player<BOARD,TURN>{
    private String name = this.getClass().getSimpleName();

    public AbstractPlayer() {
    }

    public AbstractPlayer(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
