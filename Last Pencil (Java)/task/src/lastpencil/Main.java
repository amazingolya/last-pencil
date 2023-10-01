package lastpencil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Bot bot = new Bot("Jack");

        String player1 = new Player("John").getName();
        String player2 = bot.getName();

        InputChecker checker = new InputChecker();
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many pencils would you like to use:");
        gameController.createGame(player1, player2,
                gameController.getTotalPencils(scanner, checker));

        System.out.printf("Who will be the first (%s, %s):\n", player1, player2);

        gameController.makeMove(scanner, checker,
                gameController.getFirstPlayer(scanner, checker), bot);

        System.out.println(gameController.getWinner() + " won!");
    }
}
