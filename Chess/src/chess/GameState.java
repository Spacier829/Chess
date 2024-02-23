package chess;

// Состония игры
public enum GameState {
    // Игра продолжается
    ONGOING,
    // Пад
    STALEMATE,
    // Мат белому королю
    CHECKMATE_TO_WHITE_KING,
    // Мат черному королю
    CHECKMATE_TO_BLACK_KING
}
