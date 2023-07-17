package com.vk18.tictactoe.models;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BOTDIFFICULTYLEVEL botDifficultyLevel) {
        if(botDifficultyLevel.equals(BOTDIFFICULTYLEVEL.EASY)){
            return new EasyBotPlayingStrategy();
        }
        else if(botDifficultyLevel.equals(BOTDIFFICULTYLEVEL.MEDIUM)){
            return new MediumBotPlayingStrategy();
        }else if(botDifficultyLevel.equals(BOTDIFFICULTYLEVEL.HARD)){
            return new HardBotPlayingStartegy();
        }
        return new EasyBotPlayingStrategy();
    }
}
