package chess.piece;
import chess.Color;
import chess.Coordinates;
import chess.CoordinatesShift;

import java.util.Set;

// Фигура - пешка
public class Pawn extends Piece {
    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
