package chess.piece;
import chess.Color;
import chess.Coordinates;
import chess.CoordinatesShift;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Фигура - Конь
public class Knight extends Piece {

    public Knight(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    // Метод, определяющий возможные ходы для коня
    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return new HashSet<>(Arrays.asList(
                new CoordinatesShift(1,2),
                new CoordinatesShift(2,1),

                new CoordinatesShift(2,-1),
                new CoordinatesShift(1,-2),

                new CoordinatesShift(-2,-1),
                new CoordinatesShift(-1,-2),

                new CoordinatesShift(-2,1),
                new CoordinatesShift(-1,2)
        ));
    }
}
