package boardgame;

public class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;//pe�a recem criada tem posi��o null
	}

	protected Board getBoard() {
		return board;
	}
	

}
