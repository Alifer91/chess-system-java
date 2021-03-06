package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch= new ChessMatch();
		List<ChessPiece>captured = new ArrayList<>();

		while(true) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);//UI ? a classe user interface
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source=UI.readChessPosition(sc);
				
				boolean[][]possibleMoves= chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(),possibleMoves);/*responsavel por imprimir o tabuleiro porem colorindo as posi??es possiveis*/
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target=UI.readChessPosition(sc);
				
				//se retornar uma possivel pe?a capturada(capturedPiece != null) ser? adicionada uma pe?a a lista captured
				ChessPiece capturedPiece =chessMatch.performChessMove(source, target);
				
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();//para o programa aguardar eu a apertar enter
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();//para o programa aguardar eu a apertar enter
			}
		}
	}

}
