
package de.goodyear.application;

import de.goodyear.client.Client;
import de.goodyear.game.nim.NimGame;
import de.goodyear.game.nim.player.ComputerPlayer;
import de.goodyear.game.nim.player.HumanPlayer;
import de.goodyear.io.ConsoleWriter;
import de.goodyear.io.Writer;

public class Main {
    public static void main(String[] args) {

        Writer writer = new ConsoleWriter();
        NimGame game = new NimGame(writer);
        game.addPlayer(new HumanPlayer());
        game.addPlayer(new ComputerPlayer());
        Client client = new Client(game);
        client.go();
    }
}