
package de.goodyear.application;

import de.goodyear.client.Client;
import de.goodyear.game.Game;
import de.goodyear.game.nim.NimGame;

public class Main {
    public static void main(String[] args) {

        Game game = new NimGame();
        Client client = new Client(game);
        client.go();
    }
}