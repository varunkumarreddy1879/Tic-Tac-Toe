package com.vk18.tictactoe.models;

public class Player {
    private int name;
    private Symbol symbol;
    private PLAYERTYPE playerType;

    public Player(int name, Symbol symbol, PLAYERTYPE playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PLAYERTYPE getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PLAYERTYPE playerType) {
        this.playerType = playerType;
    }
}
