package chess;

import chess.board.Board;
import chess.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        // Установка шахматных фигур на стартовые позиции
        Board board = (new BoardFactory()).fromFEN(
                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
        );

        Game game = new Game(board);
        game.gameLoop();
    }
}
