package chess.piece;

import java.util.HashSet;
import java.util.Set;

public interface IBishop {
    // Метод, определяющий возможные ходы для слона
    default Set<CoordinatesShift> getBishopMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        // Снизу слева - справа вверх
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, i));
        }

        // Сверху слева - справа вниз
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, -i));
        }
        return result;

    }
}
