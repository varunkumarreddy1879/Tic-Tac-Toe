package com.vk18.tictactoe.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Game {
    private int size;
    private Board board;
    private List<Player> players;
    private List<WinningStrategy> winningStrategies;
    private List<Move> moves;
    private Player winner;
    private int currentPlayerIndex;
    private GAMESTATUS gameStatus;

    public Game(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.size = size;
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board =new Board(this.size);
        this.moves=new ArrayList<Move>();
        this.winner=null;
        this.currentPlayerIndex=0;
        gameStatus=GAMESTATUS.INPROGRESS
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public GAMESTATUS getGameState() {
        return gameStatus;
    }

    public void setGameState(GAMESTATUS gameState) {
        this.gameStatus = gameState;
    }
}
