package com.vk18.tictactoe;

import com.vk18.tictactoe.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.vk18.tictactoe.models.Game.getBuilder;
import static java.util.ArrayList.*;

@SpringBootApplication
public class TictactoeApplication {

	public static void main(String[] args) {
		System.out.println("==================Game is starting==============");
		Scanner sc=new Scanner(System.in);
		int size=3;
		List<Player> players=new ArrayList<>();
		Player p1=new Player("varun",new Symbol('v'), PLAYERTYPE.HUMAN);
		Player p2=new BotPlayer(BOTDIFFICULTYLEVEL.EASY,new Symbol('b'));
		players.add(p1);
		players.add(p2);

		List<WinningStrategy> winningStrategies=new ArrayList<>();
		winningStrategies.add(new RowWinningStrategy(size));
		winningStrategies.add(new ColumnWinningStrategy(size));
		winningStrategies.add(new DiagonalWinningStrategy(size));

		Game game= getBuilder().setSize(size).setPlayers(players).setWinningStrategies(winningStrategies).validate();
		Board board=game.getBoard();

		while(game.getGameState().equals(GAMESTATUS.INPROGRESS)){
			game.printBoard();

			System.out.println("Anyone wants to do undo (Y/N) : ");
			String undoResponse=sc.next();

			if(undoResponse.equals("Y")){
				game.undo();
			}
			else if(undoResponse.equals("N")){
				game.makeMove();
			}
			else{
				System.out.println("Please choose correct option.");
			}

		}

		game.printBoard();

	}

}
