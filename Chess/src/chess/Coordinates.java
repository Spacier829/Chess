package chess;

import chess.piece.CoordinatesShift;

import java.util.Objects;

public class Coordinates {
    public final File file;
    public final Integer rank;

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(File.values()[this.file.ordinal() + shift.fileShift], this.rank + shift.rankShift);
    }

    public boolean canShift(CoordinatesShift shift) {
        int f = file.ordinal() + shift.fileShift;
        int r = rank + shift.rankShift;

        if (f < 0 || f > 7) return false; // 0..7 -> буквы
        if (r < 1 || r > 8) return false; // 1..8 -> цифры

        return true;
    }

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
}
