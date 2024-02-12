package chess.piece;

import chess.Color;
import chess.Board;
import chess.Coordinates;
import chess.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

abstract public class Piece {
    // Цвет фигуры
    public final Color color;
    // Координаты, на которых стоит фигура
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }

    // Метод, определяющий свободные клетки для хода
    public Set<Coordinates> getAvailableMoveSquares(Board board) {
        Set<Coordinates> result = new HashSet<>();
        for (CoordinatesShift shift : getPieceMoves()) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.shift((shift));

                if (isSquareAvailableForMove(newCoordinates, board)) {
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    // Проверка доступности клетки для хода фигуры
    private boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        return board.isSquareEmpty(coordinates) || board.getPiece(coordinates).color != color;
    }

    // Метод, возвращающий возможные ходы фигур
    protected abstract Set<CoordinatesShift> getPieceMoves();
}
