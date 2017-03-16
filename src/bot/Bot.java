package bot;

import rockpaperscissors.Move;
import rockpaperscissors.Result;

public interface Bot {
	
	void newGame();
	
	Move nextMove();
	
	void lastResult(Result result, Move oppositionMove);
}
