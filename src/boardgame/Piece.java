package boardgame;

public abstract class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;//pe�a recem criada tem posi��o null
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
				if(mat[i][j]) {//� o mesmo que : se a posi��o nessa matriz for true retorna true
					return true;
				}
			}
		}
		return false;
	}

}
