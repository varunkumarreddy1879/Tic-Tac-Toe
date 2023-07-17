package com.vk18.tictactoe.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    private int size;
    private List<HashMap<Symbol,Integer>> rowHashMap;

    public RowWinningStrategy(int size) {

        this.size = size;
        rowHashMap=new ArrayList<HashMap<Symbol,Integer>>();
        for(int i=0;i<size;i++){
            rowHashMap.add(new HashMap<Symbol,Integer>());
        }
    }

    @Override
    public void updateMove(int row,int col,Player player,Game game) {
        rowHashMap.get(row).put(player.getSymbol(),1+rowHashMap.get(row).getOrDefault(player.getSymbol(),0));

        if(rowHashMap.get(row).get(player.getSymbol())==size){
            game.setGameState(GAMESTATUS.ENDED);
        }
    }


    @Override
    public void undo(int row,int col,Player player){
        rowHashMap.get(row).put(player.getSymbol(),rowHashMap.get(row).get(player.getSymbol())-1);
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
