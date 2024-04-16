package chess;
import java.util.concurrent.TimeUnit;

public class Move {
	Piece p;
	public Move(String move, ChessBoard board)
	{
		String whitePiece = move.substring(0,1);
		String whiteMoveFrom = move.substring(1,3);
		String whiteMoveTo = move.substring(4,6);
		String blackPiece = move.substring(7,8); 
		String blackMoveFrom = move.substring(8,10);
		String blackMoveTo = move.substring(11);	
		
		int old_j = board.vertical.get(whiteMoveFrom.substring(0,1));
		int old_i = Integer.valueOf(whiteMoveFrom.substring(1,2));

		int new_j = board.vertical.get(whiteMoveTo.substring(0,1));
		int new_i = Integer.valueOf(whiteMoveTo.substring(1,2));
		
		board.makeMove(old_i, old_j, new_i, new_j);
		System.out.println("White move");
		board.printBoard();
		halt();
		
		old_j = board.vertical.get(blackMoveFrom.substring(0,1));
		old_i = Integer.valueOf(blackMoveFrom.substring(1,2));

		new_j = board.vertical.get(blackMoveTo.substring(0,1));
		new_i = Integer.valueOf(blackMoveTo.substring(1,2));
		
		board.makeMove(old_i, old_j, new_i, new_j);
		System.out.println("black move");
		board.printBoard();
	}
	public static void halt()
	{
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
