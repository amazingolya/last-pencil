package lastpencil;

import java.util.Scanner;

public class GameController {
    private Game game;
    public void createGame(final String player1, final String player2,
                           final int pencils) {
        game = new Game(player1, player2, pencils);
    }
    public int getTotalPencils(final Scanner scanner, final InputChecker checker) {
        String pencils;
        do {
            pencils = scanner.nextLine();
        } while (!checker.checkTotalPencils(pencils));
        return Integer.parseInt(pencils);
    }

    public int getPencilsToTake(final Scanner scanner,
                                       final InputChecker checker, final String player,
                                       final Bot bot) {
        if (player.equals(bot.getName())) {
            int botsPencils = bot.getPencils(game.getPencilsLeft());
            System.out.println(botsPencils);
            return botsPencils;
        } else {
            String pencilsToTake;
            do {
                pencilsToTake = scanner.nextLine();
            } while (!checker.checkPencilsToTake(pencilsToTake, game.getPencilsLeft()));

            return Integer.parseInt(pencilsToTake);
        }
    }

    public String getFirstPlayer(final Scanner scanner,
                                        final InputChecker checker) {
        String player;
        do {
            player = scanner.nextLine();
        } while (!checker.checkPlayerName(player, game));
        return player;
    }

    public void makeMove(final Scanner scanner,
                                final InputChecker checker, final String firstPlayer,
                                final Bot bot) {
        String player = firstPlayer;
        do {
            boolean isBot = player.equals(bot.getName());
            int pencilsLeft = game.getPencilsLeft();

            System.out.println("|".repeat(pencilsLeft));
            String pattern = isBot ? "%s's turn:\n" : "%s's turn!\n";
            System.out.printf(pattern, player);
            game.takePencils(getPencilsToTake(scanner, checker, player, bot), player);
            player = game.getNextPlayer();
        }
        while (game.getPencilsLeft() > 0);
    }

    public String getWinner() {
        String player1 = game.getPlayer1();
        return game.getNextPlayer().equals(player1) ? player1 : game.getPlayer2();
    }
}
