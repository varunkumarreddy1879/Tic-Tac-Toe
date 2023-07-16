package com.vk18.tictactoe.models;

import java.util.HashMap;
import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy{
    private List<HashMap<Symbol,Integer>> columnHashMap;
    int size;
    public ColumnWinningStrategy(int size) {
        for(int i=0;i<size;i++){
            columnHashMap.add(new HashMap<>());
            this.size=size;
        }
    }

    public List<HashMap<Symbol, Integer>> getColumnHashMap() {
        return columnHashMap;
    }

    public void setColumnHashMap(List<HashMap<Symbol, Integer>> columnHashMap) {
        this.columnHashMap = columnHashMap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
