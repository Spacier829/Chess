package chess;

import chess.piece.CoordinatesShift;

import java.util.Objects;

public class Coordinates {
    // Буквы
    public final File file;
    // Цифры
    public final Integer rank;

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    // Метод сдвига координат
    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(File.values()[this.file.ordinal() + shift.fileShift], this.rank + shift.rankShift);
    }

    // Метод, определяющий можно ли двигать координаты (проверка границ доски)
    public boolean canShift(CoordinatesShift shift) {
        int f = file.ordinal() + shift.fileShift;
        int r = rank + shift.rankShift;

        if (f < 0 || f > 7) return false; // 0..7 -> буквы
        if (r < 1 || r > 8) return false; // 1..8 -> цифры

        return true;
    }

    // Для использования класса в качестве ключа в HashMap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return rank == that.rank && file == that.file;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return file + String.valueOf(rank);
    }
}
