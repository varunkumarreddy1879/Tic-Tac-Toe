package com.vk18.tictactoe.models;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell getNextMove(Board board){
        int size=board.getSize();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board.getGrid().get(i).get(j).getCellState().equals(CELLSTATE.EMPTY)){
                    return board.getGrid().get(i).get(j);
                }
            }
        }

        return null;
    }
}
