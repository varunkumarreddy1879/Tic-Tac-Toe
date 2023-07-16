package com.vk18.tictactoe.models;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    private int size;
    private HashMap<Symbol,Integer> leftToRightDiagonalHashMap;
    private HashMap<Symbol,Integer> rightToLeftDiagonalHashMap;

    public DiagonalWinningStrategy(int size) {
        this.size=size;
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
