package com.vk18.tictactoe.models;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    private int size;
    private HashMap<Symbol,Integer> leftToRightDiagonalHashMap;
    private HashMap<Symbol,Integer> rightToLeftDiagonalHashMap;

    public DiagonalWinningStrategy(int size) {

        this.size=size;
        leftToRightDiagonalHashMap=new HashMap<Symbol,Integer>();
        rightToLeftDiagonalHashMap=new HashMap<Symbol,Integer>();
    }

    @Override
    public void updateMove(int row,int col,Player player,Game game) {
        if(row==col){
            leftToRightDiagonalHashMap.put(player.getSymbol(),1+leftToRightDiagonalHashMap.getOrDefault(player.getSymbol(),0));
        }
        if(row+col==size-1){
            rightToLeftDiagonalHashMap.put(player.getSymbol(),1+rightToLeftDiagonalHashMap.getOrDefault(player.getSymbol(),0));
        }

        if(row==col&&leftToRightDiagonalHashMap.get(player.getSymbol())==size){
            game.setGameState(GAMESTATUS.ENDED);
        }
        if(row+col==size-1&&rightToLeftDiagonalHashMap.get(player.getSymbol())==size){
            game.setGameState(GAMESTATUS.ENDED);
        }
    }

    @Override
    public void undo(int row,int col,Player player){
        if(row==col){
            leftToRightDiagonalHashMap.put(player.getSymbol(),leftToRightDiagonalHashMap.get(player.getSymbol())-1);
        }

        if(row+col==size-1){
            rightToLeftDiagonalHashMap.put(player.getSymbol(),rightToLeftDiagonalHashMap.get(player.getSymbol())-1);
        }
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HashMap<Symbol, Integer> getLeftToRightDiagonalHashMap() {
        return leftToRightDiagonalHashMap;
    }

    public void setLeftToRightDiagonalHashMap(HashMap<Symbol, Integer> leftToRightDiagonalHashMap) {
        this.leftToRightDiagonalHashMap = leftToRightDiagonalHashMap;
    }

    public HashMap<Symbol, Integer> getRightToLeftDiagonalHashMap() {
        return rightToLeftDiagonalHashMap;
    }

    public void setRightToLeftDiagonalHashMap(HashMap<Symbol, Integer> rightToLeftDiagonalHashMap) {
        this.rightToLeftDiagonalHashMap = rightToLeftDiagonalHashMap;
    }
}
