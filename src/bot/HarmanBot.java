package bot;

import rockpaperscissors.Move;
import rockpaperscissors.Result;

public class HarmanBot implements Bot {

    /**
     *                          Next Move
     *                    | Rock | Paper | Scissor
     *               Rock |
     *Last Move     Paper | 
     *            Scissor |
     */
    
    private int[][] markovChain; // 3x3 chain of moves

    private int lastMove, lastLastMove;

    @Override
    public void newGame() {
        // reset markov chain
        markovChain = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                markovChain[i][j] = 0;
            }
        }
        lastLastMove = -1;
        lastMove = -1;
    }

    @Override
    public Move nextMove() {
        if (lastMove < 0 || lastLastMove < 0) {
            // return random move as we don't have enough data
            return Move.random();
        }

        // pick next move
        // 1st get his last move stats
        int[] counts = markovChain[lastMove];

        // 2nd get the move that the opponent has used most often
        if (counts[1] >= counts[2] && counts[1] >= counts[0]) {
            // opponent will most likely return paper. So we return scissor
            return Move.SCISSORS;
        } else if (counts[0] >= counts[1] && counts[0] >= counts[2]) {
            // opponent will most likely return rock. So we return paper
            return Move.PAPER;
        } else {
            // default to returning rock for all you hackers
            return Move.ROCK;
        }
    }

    /**
     * Nobody's got time for making the code readable!!
     * 
     * @param move
     * @return
     */
    private int mapMoveToIndex(final Move move) {
        if (move == Move.ROCK) {
            return 0;
        } else if (move == Move.PAPER) {
            return 1;
        } else {
            // defaults to scissors for all you hackers!!
            return 2;
        }
    }

    @Override
    public void lastResult(final Result result, final Move oppositionMove) {
        // update markov chain
        lastLastMove = lastMove;
        lastMove = mapMoveToIndex(oppositionMove);
        if (lastMove >= 0 && lastMove < 3 && lastLastMove >= 0 && lastLastMove < 3) {
            markovChain[lastLastMove][lastMove] += 1;
        }

    }

}
