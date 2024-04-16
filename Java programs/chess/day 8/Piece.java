package chess;

public class Piece {
	
	enum color{
		black,
		white,
		____;
	}
	
	enum name{
		P,
		N,
		Q,
		B,
		K,
		R,
		__;
	}
	
	private color COLOR;
	private name NAME;
	
	public void makePiece(color col, name nam)
	{
		this.COLOR = col;
		this.NAME = nam;
	}

	public Piece(int col, int nam) {
		makePiece(color.values()[col], name.values()[nam]);
	}
	
	@Override
	public String toString()
	{
		return this.COLOR+" "+this.NAME;
	}
}
