package chess;

// Цвета фигур
public enum Color {
    WHITE,
    BLACK;

    // Возвращение противоположного цвета
    public Color opposite() {
        return this == WHITE ? BLACK : WHITE;
    }
}
