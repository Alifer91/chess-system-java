package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][]pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must pe at least 1 row and 1 column ");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	//retirei set rows

	public int getColumns() {
		return columns;
	}
	//retirei set columns
	
	public Piece piece(int row,int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position is not on the board ");
		}
		return pieces[row][column];
	}
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position is not on the board ");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece,Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position "+position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; //apenas foi possivel acessar o position pois ele esta como protected e � do mesmo pacote
	}
	//metodo auxiliar pois � mais facil pegar a posi��o separada (coluna e linha) do que direto a posi��o
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;//retorna condi��o
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {//testa se a posi��o existe antes de verificar se ja tem uma pe�a
			throw new BoardException("Position is not on the board ");
		}
		return piece(position) !=null; //se a pe�a dessa posi��o for diferente de null significa que tem uma pe�a 
	}

}
