package com.vk18.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> grid;

    public Board(int size) {
        this.size = size;

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
}
