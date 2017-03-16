package bot;

import java.util.Random;

import rockpaperscissors.Move;
import rockpaperscissors.Result;

public class RandomBot implements Bot {
	private static Move[] moves = {Move.PAPER, Move.SCISSORS, Move.ROCK};
	private Random rand = new Random();
    
	@Override
    public void newGame() {
    }

    @Override
    public Move nextMove() {
        return moves[rand.nextInt(3)];
    }

    @Override
    public void lastResult(final Result result, final Move oppositionMove) {
    }

}
