package com.vk18.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> grid;

    public Board(int size) {
        this.size = size;
        this.grid=new ArrayList<>();
        for(int i=0;i<this.size;i++){
            List<Cell> list=new ArrayList<Cell>();
            for(int j=0;j<this.size;j++){
                list.add(new Cell(i,j));
            }
            grid.add(list);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public void printBoard() {
        for(List<Cell> arr:grid){
            for(Cell cell:arr){
                if(cell.getCellState().equals(CELLSTATE.FILLED)){
                    System.out.print("| "+cell.getPlayer().getSymbol().getCh()+" ");
                }
                else if(cell.getCellState().equals(CELLSTATE.EMPTY)){
                    System.out.print("| - ");
                }

            }
            System.out.println("|");
        }
    }

    public void updateMove(Player player,int row,int col){
        grid.get(row).get(col).updateCell(player);
    }

    public void undo(int row, int col) {
        grid.get(row).get(col).undo();
    }
}
