package chess;

import chess.piece.Piece;

import java.sql.SQLOutput;
import java.util.Set;

public class Game {

    private final Board board;

    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            // render
            renderer.render(board);

            if (isWhiteToMove) {
                System.out.println("White move");
            } else {
                System.out.println("Black move");
            }

            // input
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    isWhiteToMove ? Color.WHITE : Color.BLACK, board
            );

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);
            // make  move
            board.movePiece(sourceCoordinates, targetCoordinates);

            // pass move
            isWhiteToMove = !isWhiteToMove;
        }
    }
}
