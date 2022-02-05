package boardgame;

public abstract class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;//peça recem criada tem posição null
	}

	protected Board getBoard() {
		return board;
	}
	public abstract boolean[][]possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i=0;i<mat.length; i++ ) {
			for(int j =0;j<mat.length;j++) {
				if(mat[i][j]) {//é o mesmo que : se a posição nessa matriz for true retorna true
					return true;
				}
			}
		}
		return false;
	}

}
