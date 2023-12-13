package de.goodyear.game;

import de.goodyear.game.Game;
import de.goodyear.game.player.Player;

public interface GameWithPlayer<BOARD,TURN> extends Game {
    void addPlayer(Player<BOARD,TURN> player);
}
