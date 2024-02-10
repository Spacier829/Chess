package chess;
import chess.piece.*;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecePostions();
//
//        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
//        renderer.render(board);
//
//        Piece piece = board.getPiece(new Coordinates(File.G, 1));
//        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
//
//        InputCoordinates input = new InputCoordinates();
//
//        Coordinates coordinates =  input.inputPieceCoordinatesForColor(Color.WHITE, board);
//
//        System.out.println("coordinates = " + coordinates);
        Game game = new Game(board);
        game.gameLoop();
        int a = 1;
    }
}
