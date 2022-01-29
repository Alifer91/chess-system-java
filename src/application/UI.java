package application;

import chess.ChessPiece;

public class UI {
	public static void printBoard(ChessPiece[][] pieces) {
		
		for(int i=0;i<pieces.length;i++) {
			System.out.print((8-i)+" ");//para fazer a contagem das posiç verticais
			for (int j=0;j<pieces.length;j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();//apenas para quebrar a linha
		}
		System.out.println("  a b c d e f g h ");

	}
	private static void printPiece(ChessPiece piece) {//metodo para imprimir uma peça
		if(piece==null) {
			System.out.print("-");//se piece for null ficara vazio	
		}
		else {
			System.out.print(piece);//caso contrario imprime a peça
		}
		System.out.print(" ");
	}
}
