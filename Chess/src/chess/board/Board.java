package chess.board;

import chess.Color;
import chess.Coordinates;
import chess.File;
import chess.piece.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Board {
    // Стартовые позиции фигур
    public final String startingFen;

    // Хранение фигур на доске
    private HashMap<Coordinates, Piece> pieces = new HashMap<>();

    // История ходов
    public List<Move> moves = new ArrayList<>();

    public Board(String startingFen) {
        this.startingFen = startingFen;
    }

    // Установка фигуры по координатам
    public void setPiece(Coordinates coordinates, Piece piece) {
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

    // Удаление фигуры с доски
    public void removePiece(Coordinates coordinates) {
        pieces.remove(coordinates);
    }

    // Перемещение фигуры по доске
    public void makeMove(Move move) {
        Piece piece = getPiece(move.from);

        removePiece(move.from);
        setPiece(move.to, piece);

        moves.add(move);
    }

    // Метод, определяющий пустая ли фигура
    public boolean isSquareEmpty(Coordinates coordinates) {
        return !pieces.containsKey(coordinates);
    }

    // Метод, возвращающий фигуры по координатам
    public Piece getPiece(Coordinates coordinates) {
        return pieces.get(coordinates);
    }

    // Метод, возвращающий состояние клетки (черная/белая)
    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }

    // Метод, возвращающий фигуры определенного цвета
    public List<Piece> getPiecesByColor(Color color) {
        List<Piece> result = new ArrayList<>();

        for (Piece piece : pieces.values()) {
            if (piece.color == color) {
                result.add(piece);
            }
        }
        return result;
    }

    // Метод, определяющий находится ли фигура под атакой
    public boolean isSquareAttackedByColor(Coordinates coordinates, Color color) {
        List<Piece> pieces = getPiecesByColor(color);

        for (Piece piece : pieces) {
            Set<Coordinates> attackedSquares = piece.getAttackedSquares(this);

            if (attackedSquares.contains(coordinates)) {
                return true;
            }
        }
        return false;
    }

}
