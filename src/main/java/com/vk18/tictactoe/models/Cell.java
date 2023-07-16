package com.vk18.tictactoe.models;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CELLSTATE cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        player = null;
        cellState=null;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CELLSTATE getCellState() {
        return cellState;
    }

    public void setCellState(CELLSTATE cellState) {
        this.cellState = cellState;
    }
}
