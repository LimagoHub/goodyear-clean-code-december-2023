package de.goodyear.game.nim;


import de.goodyear.game.AbstractGame;
import de.goodyear.io.Writer;



public class NimGame extends AbstractGame<Integer, Integer> {





    /**
     *
     * @param writer
     */
    public NimGame(final Writer writer) {
        super(writer);
        setBoard(23);
    }




    protected boolean isTurnValid() {
        return getTurn() >= 1 && getTurn() <= 3;
    }

    protected void updateBoard() {
        setBoard(getBoard()-getTurn());
    }

    protected boolean  isGameOver() {
        return getBoard() < 1 || getPlayers().isEmpty();
    }

    @Override
    protected void prepare() {
        write("\n\n" + getCurrentPlayer().getName() + " makes his turn.");
    }
}
