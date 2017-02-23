package rockpaperscissors;

public interface Bot {
	
	void newGame();
	
	Move nextMove();
	
	void lastResult(Result result, Move oppositionMove);
}
