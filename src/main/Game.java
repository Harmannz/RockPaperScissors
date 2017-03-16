package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import bot.Bot;
import bot.HarmanBot;
import bot.RPSBot;
import bot.RandomBot;
import rockpaperscissors.Move;
import rockpaperscissors.Result;

public class Game {
	private static final int MAX_GAMES = 10000;

	private void playTournament(List<Bot> bots) {
		// base case
		if (bots.size() < 2) {
			return;
		} else {
			for (int i = 1; i < bots.size(); i++) {
				playGame(bots.get(0), bots.get(i));
			}
			bots.remove(0);
			playTournament(bots);
		}
	}

	private void playGame(Bot player1, Bot player2) {
		System.out.println("\nStarting new game");
		System.out.println("Player 1: " + player1.getClass().getSimpleName());
		System.out.println("Player 2: " + player2.getClass().getSimpleName());
		player1.newGame();
		player2.newGame();
		int wonByPlayer1 = 0,wonByPlayer2 = 0, drawn = 0;
		for (int i = 0; i < MAX_GAMES; i++) {
			Move p1Move = player1.nextMove();
			Move p2Move = player2.nextMove();
			if (p1Move == p2Move) {
				player1.lastResult(Result.DRAW, p2Move);
				player2.lastResult(Result.DRAW, p1Move);
				drawn++;
			} else {
				if (p1Move.beats(p2Move)) {
					// player 1 won
					player1.lastResult(Result.WIN, p2Move);
					player2.lastResult(Result.LOSS, p1Move);
					wonByPlayer1++;
				} else {
					// player 1 lost
					player1.lastResult(Result.LOSS, p2Move);
					player2.lastResult(Result.WIN, p1Move);
					wonByPlayer2++;
				}
			}
		}
		System.out.println("Game finished\nResults");
		System.out.println("\tPlayer 1 won: " + wonByPlayer1);
		System.out.println("\tPlayer 2 won: " + wonByPlayer2);
		System.out.println("\tGames drawn: " + drawn);
		System.out.println("");
	}

	public static void main(final String[] args) {
		Game game = new Game();
		List<Bot> list = new LinkedList<Bot>(Arrays.asList(new HarmanBot(), new RandomBot(), new RPSBot()));
		game.playTournament(list);
	}
}
