package com.vk18.tictactoe.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy{
    private List<HashMap<Symbol,Integer>> columnHashMap;
    int size;
    public ColumnWinningStrategy(int size) {
        this.size=size;
        columnHashMap=new ArrayList<HashMap<Symbol,Integer>>();
        for(int i=0;i<size;i++){
            columnHashMap.add(new HashMap<Symbol,Integer>());
        }
    }


    @Override
    public void updateMove(int row,int col,Player player,Game game) {
        columnHashMap.get(col).put(player.getSymbol(),1+columnHashMap.get(col).getOrDefault(player.getSymbol(),0));

        if(columnHashMap.get(col).get(player.getSymbol())==size){
            game.setGameState(GAMESTATUS.ENDED);
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
