package ab12;

import java.util.*;

public class ThreePawnsAI {
	public static String nextMove(Board board) {
		int[] spaces = getSpaces(board);
		List<Move> freeMoves = getPossibleMoves(board);
		
		
		
		Random random = new Random();
		
		Move nextMove = freeMoves.get(random.nextInt(freeMoves.size()));
		
		return nextMove.toString();
	}

	private static int[] getSpaces(Board board) {
		int[] sps = new int[3];

		for (int i = 0; i < 3; i++) {
			sps[i] = board.getPawns()[i][1].getX() - board.getPawns()[i][0].getX();
		}
		return sps;
	}

	private static List<Move> getPossibleMoves(Board board)
	{
		List<Move> result = new ArrayList<ThreePawnsAI.Move>();
		for(int i=0;i<3;i++)
		{
			for(int j=board.getPawns()[i][0].getX()+1;j<9;j++)
			{
				if(board.getPawns()[i][1].getX()!=j)
					result.add(new Move(j,i));
			}
			
		}
		
		return result;
	}
	
	private static class Move {
		Move(int x, int y) {
			this.x = x;
			this.y = y;
		}

		private int x;

		private int getX() {
			return x;
		}

		private int y;

		private int getY() {
			return y;
		}
		
		@Override
		public String toString()
		{
			return Board.RowTypes.values()[getY()].toString()+getX();
		}
		
	}

}
