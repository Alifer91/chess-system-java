package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	@Override
	public boolean[][] possibleMoves() {
		/*ao instanciar a matriz  define como false toda a matriz*/
		boolean[][] mat = new boolean [getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);//posição auxiliar apenas para ter um valor inicial
		//acima da peça
		p.setValues(position.getRow()-1, position.getColumn());//seleciona a linha acima da posição da propria PEÇA
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			p.setRow(p.getRow()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {//se existir uma peça adversaria marcar tambem
			mat[p.getRow()][p.getColumn()]= true;
		}
		//esquerda 
		p.setValues(position.getRow(), position.getColumn()-1);//seleciona a coluna a esquerda da posição da propria PEÇA
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			p.setColumn(p.getColumn()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]= true;
		}
		//direita 
		p.setValues(position.getRow(), position.getColumn()+1);//seleciona a coluna a direita da posição da propria PEÇA
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			p.setColumn(p.getColumn()+1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]= true;
		}
		//abaixo
		p.setValues(position.getRow()+1, position.getColumn());//seleciona a linha abaixo da posição da propria PEÇA
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			p.setRow(p.getRow()+1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getRow()]= true;
		}
		return mat;
	}

}
