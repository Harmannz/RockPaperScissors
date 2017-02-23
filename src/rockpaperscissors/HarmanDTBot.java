package rockpaperscissors;

public class HarmanDTBot implements Bot {

	// create collection for paper, scissor, rock
	Node paper, scissor, rock;
	@Override
	public void newGame() {
		paper.reset();
		scissor.reset();
		rock.reset();
	}

	@Override
	public Move nextMove() {
		return null;
	}

	@Override
	public void lastResult(Result result, Move oppositionMove) {
	}

	private class Node{
		private int won, lost;

		public void reset(){
			won = 0;
			lost = 0;
		}

		public int getWon() {
			return won;
		}

		public int getLost() {
			return lost;
		}
		
		public double calculateImpurity(){
			return 0;
		}
	}
	
}
