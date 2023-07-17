package com.vk18.tictactoe.models;

import java.util.List;

public class BotPlayer extends Player{
    private BOTDIFFICULTYLEVEL botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;


    public BotPlayer(BOTDIFFICULTYLEVEL botDifficultyLevel, Symbol symbol) {
        super("Bot",symbol,PLAYERTYPE.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy=BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    public BOTDIFFICULTYLEVEL getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BOTDIFFICULTYLEVEL botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public void makeMove(Board board, List<WinningStrategy> winningStrategies, Game game){
        Cell cell=botPlayingStrategy.getNextMove(board);

        board.updateMove(this,cell.getRow(),cell.getCol());
        game.addtoMoves(this, cell.getRow(), cell.getCol());

        System.out.println(this.getName() +" made a move at row "+ cell.getRow()+" col "+cell.getCol());

        for(WinningStrategy winningStrategy:winningStrategies){
            winningStrategy.updateMove(cell.getRow(),cell.getCol(),this,game);
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
                System.out.println(this.getName() + " won the game");
                System.out.println("=============================================================================");
                break;
            }
        }


        game.setCurrentPlayerIndex((game.getCurrentPlayerIndex()+1) % (game.getSize()-1));
    }

//    private boolean validateMove(Board board,int row,int col){
//        if(row<0||col<0||row>=board.getSize()||col>=board.getSize()||(!board.getGrid().get(row).get(col).getCellState().equals(CELLSTATE.EMPTY))){
//            return false;
//        }
//        return true;
//    }
}
