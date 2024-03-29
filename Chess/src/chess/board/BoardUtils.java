package chess.board;

import chess.Coordinates;
import chess.File;

import java.util.ArrayList;
import java.util.List;

// Вспомогательные методы, для получения доступных ходов
public class BoardUtils {
    // Метод для получения ходов по диагонали
    public static List<Coordinates> getDiagonalsCoordinatesBetween(Coordinates source, Coordinates target) {
        // Допущение - что 2 клетки лежат на 1 диагонали

        List<Coordinates> result = new ArrayList<>();

        int fileShift = source.file.ordinal() < target.file.ordinal() ? 1 : -1;
        int rankShift = source.rank < target.rank ? 1 : -1;

        for (
                int fileIndex = source.file.ordinal() + fileShift,
                rank = source.rank + rankShift;

                fileIndex != target.file.ordinal() && rank != target.rank;
                fileIndex += fileShift, rank += rankShift
        ) {
            result.add(new Coordinates(File.values()[fileIndex], rank));
        }
        return result;
    }

    // Метод, для получения ходов по вертикали
    public static List<Coordinates> getVerticalCoordinatesBetween(Coordinates source, Coordinates target) {
        // Допущение - что 2 клетки лежат на 1 вертикали

        List<Coordinates> result = new ArrayList<>();

        int rankShift = source.rank < target.rank ? 1 : -1;

        for (int rank = source.rank + rankShift; rank != target.rank; rank += rankShift) {
            result.add(new Coordinates(source.file, rank));
        }
        return result;
    }

    // Метод для полчения ходов по горизонтали
    public static List<Coordinates> getHorizontalCoordinatesBetween(Coordinates source, Coordinates target) {
        // Допущение - что 2 клетки лежат на 1 горизонтали

        List<Coordinates> result = new ArrayList<>();

        int fileShift = source.file.ordinal() < target.file.ordinal() ? 1 : -1;
        for (int fileIndex = source.file.ordinal() + fileShift; fileIndex != target.file.ordinal(); fileIndex += fileShift) {
            result.add(new Coordinates(File.values()[fileIndex], source.rank));
        }
        return result;
    }
}
