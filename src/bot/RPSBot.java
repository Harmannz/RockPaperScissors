package bot;

import rockpaperscissors.Move;
import rockpaperscissors.Result;

public class RPSBot implements Bot{
    private int counter;
        
    @Override
    public void newGame() {
    	counter = 0;
    }

    
    @Override
    public Move nextMove() {
        counter++;
        int mod = counter % 3;
        if (mod == 0) {
            return Move.PAPER;
        } else if (mod == 1) {
            return Move.ROCK;
        } else {
            return Move.SCISSORS;
        }
    }

    @Override
    public void lastResult(final Result result, final Move oppositionMove) {
    }
}
