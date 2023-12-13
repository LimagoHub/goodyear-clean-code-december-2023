package de.goodyear.game;

import de.goodyear.game.player.Player;
import de.goodyear.io.Writer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractGame<BOARD,TURN> implements Game{

    private BOARD board;
    private TURN turn;
    private List<Player<BOARD,TURN>> players = new ArrayList<>();
    private Player<BOARD,TURN> currentPlayer;

    private final Writer writer;

    protected AbstractGame(final Writer writer) {
        this.writer = writer;
    }

    protected BOARD getBoard() {
        return board;
    }

    protected void setBoard(final BOARD board) {
        this.board = board;
    }

    protected TURN getTurn() {
        return turn;
    }

    protected void setTurn(final TURN turn) {
        this.turn = turn;
    }

    protected List<Player<BOARD, TURN>> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    protected Player<BOARD, TURN> getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer(final Player<BOARD, TURN> currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void addPlayer(Player<BOARD,TURN> player) {
        players.add(player);

    }
    public void removePlayer(Player<BOARD,TURN> player) {
        players.remove(player);


    }

    /**
     *
     */
    @Override
    public final void play() {  // Most abstract
        while( ! isGameOver()) {
            playSingleRound();
        }
    }

    private void playSingleRound() {

        for(var player: players) {
            setCurrentPlayer(player);
            playSingleMove();
        }
    }

    private void playSingleMove() {

        if(initTurn()) return;
        executeMoveAndRepeatUntilValid();
        terminateTurn( );
    }

    private boolean initTurn() {
        prepare();
        return isGameOver();
    }

    private void executeMoveAndRepeatUntilValid() {
        do {
            turn = getCurrentPlayer().doTurn(board);
        } while(thisTurnIsInvalid());

    }

    private void terminateTurn() {
        updateBoard();
        printGameoverMessageIfGameIsOver();
    }

    private boolean thisTurnIsInvalid() {
        if(isTurnValid()) return false;
        write("Invalid turn");
        return true;
    }
    protected void write(String message) {
        writer.write(message);
    }
    private void printGameoverMessageIfGameIsOver() {
        if(isGameOver()) {
            write(getCurrentPlayer().getName() + " loose");
        }
    }

    // -----------------------------

    protected void prepare() {
        // OK
    }
    protected abstract  boolean  isGameOver();

    abstract protected boolean isTurnValid() ;

    abstract protected void updateBoard() ;
}
