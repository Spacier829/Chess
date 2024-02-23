package chess.piece;

import chess.Color;
import chess.Coordinates;

import java.util.Set;

// Фигура - ладья
public class Rook extends LongRangePiece implements IRook {
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getRookMoves();
    }
}
