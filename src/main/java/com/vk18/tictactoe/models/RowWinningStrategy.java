package com.vk18.tictactoe.models;

import java.util.HashMap;
import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    private int size;
    private List<HashMap<Symbol,Integer>> rowHashMap;

    public RowWinningStrategy(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<HashMap<Symbol, Integer>> getRowHashMap() {
        return rowHashMap;
    }

    public void setRowHashMap(List<HashMap<Symbol, Integer>> rowHashMap) {
        this.rowHashMap = rowHashMap;
    }
}
