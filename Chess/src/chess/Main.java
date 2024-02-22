package chess;
import chess.piece.*;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecePostions();

        Board board = (new BoardFactory()).fromFEN(
                "3k4/6r1/8/1P2Q3/2B5/6P1/2R1r3/3K4 w - - 0 1"
        );
//
        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
//        renderer.render(board);
//
//        Piece piece = board.getPiece(new Coordinates(File.G, 1));
//        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
//
//        InputCoordinates input = new InputCoordinates();
//
//        Coordinates coordinates =  input.inputPieceCoordinatesForColor(Color.WHITE, board);
//
////        System.out.println("coordinates = " + coordinates);
        Game game = new Game(board);
        game.gameLoop();
        int a = 1;
    }
}
