package chess;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private int turn;
	private Color currentPlayer;
	private Board board;
	// listas de controle de pe�as capturadas e pe�as no tabuleiro
	private List<Piece> piecesOnTheBoard= new ArrayList<>();
	private List<Piece> capturedPieces= new ArrayList<>();
	public ChessMatch () {
		board = new Board(8,8);
		turn = 1;
		currentPlayer =Color.WHITE;
		initialSetup();
	}
	public int getTurn() {
		return turn;
	}
	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	public ChessPiece [][] getPieces(){
		ChessPiece [][]mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i =0;i<board.getRows();i++) {
			for( int j =0;j<board.getColumns();j++) {
				mat[i][j]=(ChessPiece) board.piece(i, j); //para o programa interpretar como uma pe�a de chadrez e n�o umape�a comum
			}
		}
		return mat;
	}
	public boolean[][]possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
		/*serve para que possa imprimir na aplica��o as posi��es possiveis a partir de uma posi��o de origem*/
		}
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		//sourceposition=posi�ao de origem
		//target position =posi��o alvo
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source,target);
		nextTurn();
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove(Position source,Position target) {
		Piece p = board.removePiece(source);//remove da posi��o de origem
		Piece capturedPiece = board.removePiece(target);//remove uma possivel pe�a que j� esteja na posi��o de destino
		board.placePiece(p, target);//agora � possivel colocar a pe�a p na posi��o de destino
		
		if(capturedPiece !=null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		return capturedPiece;
	}
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("The Chosen Piece is not yours");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {//se n�o tiver um movimento possivel ent�o lan�e uma exce��o
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	private void validateTargetPosition(Position source,Position target) {
		if(!board.piece(source).possibleMove(target)){//se para a pe�a de origem o movimento n�o � possivel , n�o mova para l�
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;// se a cor � branca ent�o passa a ser preta senao continua branca
	}
	private void placeNewPiece(char column, int row , ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		//assim que colocar a pe�a no tabuleiro ela ja � adicionada tambem na lista de pe�as no tabuleiro
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}

}
