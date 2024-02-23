package chess;

import chess.board.Board;
import chess.board.Move;

import java.util.List;

public class Game {
    private final Board board;
    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();
    private final List<GameStateChecker> checkers = List.of(
            new StalemateGameStateChecker(),
            new ChekmateGameStateChecker()
    );

    public Game(Board board) {
        this.board = board;
    }

    // Метод игрового цикла
    public void gameLoop() {
        Color colorToMove = Color.WHITE;

        GameState state = deteremineGameState(board, colorToMove);

        while (state == GameState.ONGOING) {
            // Отрисовка доски
            renderer.render(board);

            // Обработка хода - ход белых, ход черных
            if (colorToMove == Color.WHITE) {
                System.out.println("White move");
            } else {
                System.out.println("Black move");
            }

            Move move = InputCoordinates.inputMove(board, colorToMove, renderer);

            // make  move
            board.makeMove(move);

            // pass move
            colorToMove = colorToMove.opposite();

            state = deteremineGameState(board, colorToMove);
        }

        renderer.render(board);
        System.out.println("Game ended with state = " + state);
    }

    private GameState deteremineGameState(Board board, Color color) {
        for (GameStateChecker checker : checkers) {
            GameState state = checker.check(board, color);

            if (state != GameState.ONGOING) {
                return state;
            }
        }

        return GameState.ONGOING;
    }
}
