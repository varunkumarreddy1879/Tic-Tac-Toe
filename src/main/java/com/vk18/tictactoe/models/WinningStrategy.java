package com.vk18.tictactoe.models;

import java.util.HashMap;
import java.util.List;

public interface WinningStrategy {
    public void updateMove(int row,int col,Player player,Game game);

}
