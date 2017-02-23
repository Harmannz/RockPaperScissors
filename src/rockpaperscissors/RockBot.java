package rockpaperscissors;

public class RockBot implements Bot {

	@Override
	public void newGame() {
	}

	@Override
	public Move nextMove() {
		return Move.ROCK;
	}

	@Override
	public void lastResult(Result result, Move oppositionMove) {
	}

}
