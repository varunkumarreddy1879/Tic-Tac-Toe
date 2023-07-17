package com.vk18.tictactoe.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Game {
    private int size;
    private Board board;
    private List<Player> players;
    private List<WinningStrategy> winningStrategies;
    private List<Move> moves;
    private Player winner;
    private int currentPlayerIndex;
    private GAMESTATUS gameStatus;

    public static Builder getBuilder(){
        return new Builder();
    }

    public void addtoMoves(Player player, int row, int col) {
        Move move=new Move(board.getGrid().get(row).get(col),player);
        moves.add(move);
    }

    public static class Builder{
        private int size;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        private Builder() {
        }

        public int getSize() {
            return size;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game validate(){
            if(size<3){
                throw new RuntimeException();
            }

            if(players.size()!=size-1){
                throw new RuntimeException();
            }

            int botsCount=0;
            HashSet<Character> symbols=new HashSet<>();
            for(Player player:players){
                if(symbols.contains(player.getSymbol().getCh())){
                    throw new RuntimeException();
                }
                symbols.add(player.getSymbol().getCh());

                if(player.getPlayerType().equals(PLAYERTYPE.BOT)){
                    botsCount++;
                    if(botsCount>1){
                        throw new RuntimeException();
                    }
                }
            }

            return new Game(size,players,winningStrategies);
        }
    }

    private Game(int size, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.size = size;
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board =new Board(this.size);
        this.moves=new ArrayList<Move>();
        this.winner=null;
        this.currentPlayerIndex=0;
        gameStatus=GAMESTATUS.INPROGRESS;
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

    public void printBoard() {
        board.printBoard();
    }

    public void undo() {
    }

    public void makeMove() {
        players.get(currentPlayerIndex).makeMove(board,winningStrategies,this);
    }

    public void checkStatus() {
    }
}
