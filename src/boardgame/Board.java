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
		piece.position = position; //apenas foi possivel acessar o position pois ele esta como protected e é do mesmo pacote
	}
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {//programaçao defensiva
			throw new BoardException("Position is not on the board ");
		}
		if (piece(position)== null) {
			return null;
		}
		Piece aux =piece(position);
		aux.position = null;//transforma a posição da peça em null
		pieces[position.getRow()][position.getColumn()]= null;
		return aux;
	}
	//metodo auxiliar pois é mais facil pegar a posição separada (coluna e linha) do que direto a posição
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;//retorna condição
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {//testa se a posição existe antes de verificar se ja tem uma peça
			throw new BoardException("Position is not on the board ");
		}
		return piece(position) !=null; //se a peça dessa posição for diferente de null significa que tem uma peça 
	}
	

}
