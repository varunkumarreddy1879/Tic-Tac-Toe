package com.vk18.tictactoe.models;

public class BotPlayer extends Player{
    private BOTDIFFICULTYLEVEL botDifficultyLevel;

    public BotPlayer(BOTDIFFICULTYLEVEL botDifficultyLevel,Symbol symbol) {
        this.playerType=PLAYERTYPE.BOT;
        this.botDifficultyLevel = botDifficultyLevel;
        this.symbol=symbol;
        this.name="Bot";
    }

    public BOTDIFFICULTYLEVEL getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BOTDIFFICULTYLEVEL botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
