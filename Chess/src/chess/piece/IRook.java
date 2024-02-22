package chess.piece;

import java.util.HashSet;
import java.util.Set;

public interface IRook {
    default Set<CoordinatesShift> getRookMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        // слева - направо
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i, 0));
        }

        // снизу - вверх
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(0, i));
        }
        return result;
    }
}
