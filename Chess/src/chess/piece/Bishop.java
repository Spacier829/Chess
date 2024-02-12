package chess.piece;
import chess.Color;
import chess.Coordinates;
import chess.CoordinatesShift;

import java.util.Set;

// Фигура - слон
public class Bishop extends Piece {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
