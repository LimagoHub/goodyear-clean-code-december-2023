package de.goodyear.game.nim.player;

import de.goodyear.game.player.AbstractPlayer;

public abstract class AbstractNimGamePlayer extends AbstractPlayer<Integer,Integer> {

    protected AbstractNimGamePlayer() {
    }

    public AbstractNimGamePlayer(final String name) {
        super(name);
    }


}