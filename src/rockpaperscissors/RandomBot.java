package rockpaperscissors;

public class RandomBot implements Bot {

    @Override
    public void newGame() {
        // TODO Auto-generated method stub

    }

    private int counter = 0;

    @Override
    public Move nextMove() {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub

    }

    public static void main(final String[] args) {
        RandomBot rb = new RandomBot();
        HarmanBot hb = new HarmanBot();

        rb.newGame();
        hb.newGame();
        int wonByHarman = 0;
        int lossByHarman = 0;
        int drawnByHarman = 0;
        for (int i = 0; i < 10000; i++) {
            Move hbMove = hb.nextMove();
            Move rbMove = rb.nextMove();
            if (hbMove == rbMove) {
                hb.lastResult(Result.DRAW, rbMove);
                rb.lastResult(Result.DRAW, hbMove);
                drawnByHarman++;
            } else {
                if (hbMove.beats(rbMove)) {
                    // harman won
                    hb.lastResult(Result.WIN, rbMove);
                    rb.lastResult(Result.LOSS, hbMove);
                    wonByHarman++;
                } else {
                    hb.lastResult(Result.LOSS, rbMove);
                    rb.lastResult(Result.WIN, hbMove);
                    lossByHarman++;
                }
            }
        }

        System.out.println("won: " + wonByHarman);
        System.out.println("loss: " + lossByHarman);
        System.out.println("drawn: " + drawnByHarman);
    }
}
