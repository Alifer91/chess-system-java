package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	@Override
	public String toString() {
		return "K";
	}
	private boolean canMove (Position position) {
		ChessPiece p =(ChessPiece)getBoard().piece(position);
		return p ==null ||p.getColor() != getColor();//verifica se a posi��o esta vazia ou se a cor � diferente
	}
	@Override
	public boolean[][] possibleMoves() {
		/*ao instanciar a matriz  define como false toda a matriz*/
		boolean[][] mat = new boolean [getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
		//acima
		p.setValues(position.getRow()-1, position.getColumn());
		if(getBoard().positionExists(p)&& canMove(p)) {//se posi��o p existe e pode ser movida ent�o o rei pode mover para essa posi��o
			mat[p.getRow()][p.getColumn()]= true;
		}
		//abaixo
		p.setValues(position.getRow()+1, position.getColumn());
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
		}
		//esquerda
		p.setValues(position.getRow(), position.getColumn()-1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
		}
		//direita
		p.setValues(position.getRow(), position.getColumn()+1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
		}
		//noroeste
		p.setValues(position.getRow()-1, position.getColumn()-1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
		}
		//nordeste
		p.setValues(position.getRow()-1, position.getColumn()+1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
		}
		//sudoeste
		p.setValues(position.getRow()+1, position.getColumn()-1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
		}
		//sudeste
		p.setValues(position.getRow()+1, position.getColumn()+1);
		if(getBoard().positionExists(p)&& canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
		}
		
		return mat;
	}
	

}
