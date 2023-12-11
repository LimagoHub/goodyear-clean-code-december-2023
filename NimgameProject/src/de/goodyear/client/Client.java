package de.goodyear.client;

import de.goodyear.game.Game;

public class Client {

    private final Game game;

    public Client(final Game game) {
        this.game = game;
    }

    public void go() {
        game.play();
    }
}
