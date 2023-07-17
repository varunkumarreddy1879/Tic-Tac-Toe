package com.vk18.tictactoe.models;

public interface BotPlayingStrategy {
    public Cell getNextMove(Board board);
}
