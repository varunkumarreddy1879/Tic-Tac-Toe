package com.vk18.tictactoe.models;

import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PLAYERTYPE playerType;

    public Player(String name, Symbol symbol, PLAYERTYPE playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PLAYERTYPE getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PLAYERTYPE playerType) {
        this.playerType = playerType;
    }

    public void makeMove(Board board, List<WinningStrategy> winningStrategies,Game game) {
        Scanner sc=new Scanner(System.in);
        System.out.println(name+ " please enter the row number : ");
        int row=sc.nextInt();
        System.out.println(name+ " please enter the col number : ");
        int col=sc.nextInt();

        if(!validateMove(board,row,col)){
            System.out.println("Invalid move");
            return;
        }

        board.updateMove(this,row,col);
        game.addtoMoves(this,row,col);


        System.out.println(name +" made a move at row "+ row+" col "+col);
        //System.out.println("move updated");
        for(WinningStrategy winningStrategy:winningStrategies){
            winningStrategy.updateMove(row,col,this,game);
        }

        for(WinningStrategy winningStrategy:winningStrategies){
            GAMESTATUS gamestatus=game.getGameState();
            if(gamestatus.equals(GAMESTATUS.DRAW)){
                game.setGameState(GAMESTATUS.DRAW);
                System.out.println("Game is Draw");
                System.out.println("=============================================================================");
                break;
            }
            else if(gamestatus.equals(GAMESTATUS.ENDED)){
                game.setGameState(GAMESTATUS.ENDED);
                game.setWinner(this);
                System.out.println(name + " won the game");
                System.out.println("=============================================================================");
                break;
            }
        }


        game.setCurrentPlayerIndex((game.getCurrentPlayerIndex()+1) % (game.getSize()-1));

        //System.out.println(game.getCurrentPlayerIndex());
    }

    private boolean validateMove(Board board,int row,int col){
        if(row<0||col<0||row>=board.getSize()||col>=board.getSize()||(!board.getGrid().get(row).get(col).getCellState().equals(CELLSTATE.EMPTY))){
            return false;
        }
        return true;
    }

}
