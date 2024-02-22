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

    // Метод игрового цикла
    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            // Отрисовка доски
            renderer.render(board);

            // Обработка хода - ход белых, ход черных
            if (isWhiteToMove) {
                System.out.println("White move");
            } else {
                System.out.println("Black move");
            }

            // Ввод координат пользователем
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    isWhiteToMove ? Color.WHITE : Color.BLACK, board
            );

            // Получение доступных ходов
            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

            renderer.render(board, piece);
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);
            // make  move
            board.movePiece(sourceCoordinates, targetCoordinates);

            // pass move
            isWhiteToMove = !isWhiteToMove;
        }
    }
}
