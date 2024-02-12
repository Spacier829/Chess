package chess;

public enum File {
    A, B, C, D, E, F, G, H;

    // Метод, преобразующий символ в значение буквы
    public static File fromChar(char c) {
        try {
            return File.valueOf(String.valueOf(c).toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
