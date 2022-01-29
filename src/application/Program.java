package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		ChessMatch chessMatch= new ChessMatch();
		
		UI.printBoard(chessMatch.getPieces());//UI é a classe user interface
	}

}
