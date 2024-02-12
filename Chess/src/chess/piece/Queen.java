package chess.piece;
import chess.Color;
import chess.Coordinates;
import chess.CoordinatesShift;

import java.util.Set;

// Фигура - ферзь
public class Queen extends Piece {
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
