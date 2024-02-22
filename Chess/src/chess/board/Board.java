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
    public final String startingFen;
    // Хранение фигур на доске
    private HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public List<Move> moves = new ArrayList<>();

    public Board(String startingFen) {
        this.startingFen = startingFen;
    }

    // Метод установки фигур по координатам
    public void setPiece(Coordinates coordinates, Piece piece) {
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

    // Удаление фигуры с доски
    public void removePiece(Coordinates coordinates) {
        pieces.remove(coordinates);
    }

    // Перемещение фигруры по доске
    public void makeMove(Move move) {
        Piece piece = getPiece(move.from);

        removePiece(move.from);
        setPiece(move.to, piece);

        moves.add(move);
    }

    // Метод возвращающий состояние клетки (есть на ней фигура или нет)
    public boolean isSquareEmpty(Coordinates coordinates) {
        return !pieces.containsKey(coordinates);
    }

    // Метод возвращающий фигуры по координатам
    public Piece getPiece(Coordinates coordinates) {
        return pieces.get(coordinates);
    }

    // Метод установки фигур на стартовые позиции
    public void setupDefaultPiecePostions() {
        // Установка пешек
        for (File file : File.values()) {
            setPiece(new Coordinates(file, 2), new Pawn(Color.WHITE, new Coordinates(file, 2)));
            setPiece(new Coordinates(file, 7), new Pawn(Color.BLACK, new Coordinates(file, 7)));
        }

        // Установка ладей
        setPiece(new Coordinates(File.A, 1), new Rook(Color.WHITE, new Coordinates(File.A, 1)));
        setPiece(new Coordinates(File.H, 1), new Rook(Color.WHITE, new Coordinates(File.H, 1)));
        setPiece(new Coordinates(File.A, 8), new Rook(Color.BLACK, new Coordinates(File.A, 8)));
        setPiece(new Coordinates(File.H, 8), new Rook(Color.BLACK, new Coordinates(File.H, 8)));

        // Установка коней
        setPiece(new Coordinates(File.B, 1), new Knight(Color.WHITE, new Coordinates(File.B, 1)));
        setPiece(new Coordinates(File.G, 1), new Knight(Color.WHITE, new Coordinates(File.G, 1)));
        setPiece(new Coordinates(File.B, 8), new Knight(Color.BLACK, new Coordinates(File.B, 8)));
        setPiece(new Coordinates(File.G, 8), new Knight(Color.BLACK, new Coordinates(File.G, 8)));

        // Устанока слонов
        setPiece(new Coordinates(File.C, 1), new Bishop(Color.WHITE, new Coordinates(File.C, 1)));
        setPiece(new Coordinates(File.F, 1), new Bishop(Color.WHITE, new Coordinates(File.F, 1)));
        setPiece(new Coordinates(File.C, 8), new Bishop(Color.BLACK, new Coordinates(File.C, 8)));
        setPiece(new Coordinates(File.F, 8), new Bishop(Color.BLACK, new Coordinates(File.F, 8)));

        //Установка ферзей
        setPiece(new Coordinates(File.D, 1), new Queen(Color.WHITE, new Coordinates(File.D, 1)));
        setPiece(new Coordinates(File.D, 8), new Queen(Color.BLACK, new Coordinates(File.D, 8)));

        // Установка королей
        setPiece(new Coordinates(File.E, 1), new King(Color.WHITE, new Coordinates(File.E, 1)));
        setPiece(new Coordinates(File.E, 8), new King(Color.BLACK, new Coordinates(File.E, 8)));
    }

    // Метод возвращающий состояние клетки (черная/белая)
    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }

    public List<Piece> getPiecesByColor(Color color) {
        List<Piece> result = new ArrayList<>();

        for (Piece piece : pieces.values()) {
            if (piece.color == color) {
                result.add(piece);
            }
        }
        return result;
    }

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
