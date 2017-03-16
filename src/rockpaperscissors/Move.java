package rockpaperscissors;

public enum Move {
	ROCK, PAPER, SCISSORS;

	public boolean beats(Move move) {
		return move.beatenBy() == this;
	}

	public Move beatenBy() {
		switch (this) {
		case ROCK:
			return PAPER;
		case SCISSORS:
			return ROCK;
		case PAPER:
			return Move.SCISSORS;
		default:
			throw new IllegalStateException();
		}
	}

	public static Move random() {
		switch ((int) (Math.random() * 3)) {
		case 0:
			return Move.ROCK;
		case 1:
			return Move.SCISSORS;
		case 2:
			return Move.PAPER;
		default:
			return null;
		}
	}
}
