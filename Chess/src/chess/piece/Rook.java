package chess.piece;
import chess.Color;
import chess.Coordinates;
import chess.CoordinatesShift;

import java.util.Set;

// Фигура - ладья
public class Rook extends Piece {
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
