package chess.piece;

import chess.Color;
import chess.Coordinates;

import java.util.Set;

// Фигура - слон
public class Bishop extends LongRangePiece implements IBishop {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    // Метод, определяющий доступные клетки для хода слона
    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getBishopMoves();
    }
}
