package chess;

import chess.piece.Piece;

import java.util.Set;

import static java.util.Collections.emptySet;

// Отрисовка в консоли шахматной доски
public class BoardConsoleRenderer {

    // Константы для цветов шахматной сетки
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQAURE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQAURE_BACKGROUND = "\u001B[0;100m";
    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";

    // Отрисовка шахматной доски
    public void render(Board board, Piece pieceToMove) {
        Set<Coordinates> availableMoveSquares = emptySet();
        if (pieceToMove != null) {
            availableMoveSquares = pieceToMove.getAvailableMoveSquares(board);
        }

        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                boolean isHighlight = availableMoveSquares.contains(coordinates);


                if (board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates, isHighlight);
                } else {
                    line += getPieceSprite(board.getPiece(coordinates), isHighlight);
                }
            }
            line += ANSI_RESET;
            line += " " + rank;
            System.out.println(line);
        }
        String line = "";
        for (File file : File.values()) {
            line += " " + file + " ";
        }
        System.out.println(line);
    }

    public void render(Board board) {
        render(board, null);
    }

    // Установка цветов для элементов доски и фигур
    private String colorizeSprite(String sprite, Color pieceColor, boolean isSqaureDark, boolean isHighlighted) {
        // format = background color + font color + text
        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isHighlighted) {
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        }
        if (isSqaureDark) {
            result = ANSI_BLACK_SQAURE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQAURE_BACKGROUND + result;
        }

        return result;
    }

    // Метод для отрисовки пустой клетки
    private String getSpriteForEmptySquare(Coordinates coordinates, boolean isHighlight) {
        return colorizeSprite("   ", Color.WHITE, Board.isSquareDark(coordinates), isHighlight);
    }

    // Метод для получение юникода фигуры
    private String selectUnicodeSpriteForPiece(Piece piece) {
        String str = piece.getClass().getName();
        switch (piece.getClass().getName()) {
            case "chess.piece.Pawn" -> {
                return "♟";
            }
            case "chess.piece.Knight" -> {
                return "♞";
            }
            case "chess.piece.Bishop" -> {
                return "♝";
            }
            case "chess.piece.Rook" -> {
                return "♜";
            }
            case "chess.piece.Queen" -> {
                return "♛";
            }
            case "chess.piece.King" -> {
                return "♚";
            }
        }
        return " ";
    }

    // Метод для отрисовки фигуры на доске
    private String getPieceSprite(Piece piece, boolean isHighlight) {
        return colorizeSprite(" " + selectUnicodeSpriteForPiece(piece) + " ", piece.color, Board.isSquareDark(piece.coordinates), isHighlight);
    }
}