package lastpencil;

public class Game {
    private final String player1;
    private final String player2;
    private int pencilsLeft;
    private String nextPlayer = "";
    public Game(String player1, String player2, final int totalPencils) {
        this.player1 = player1;
        this.player2 = player2;
        this.pencilsLeft = totalPencils;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public int getPencilsLeft() {
        return pencilsLeft;
    }

    public String getNextPlayer() {
        return nextPlayer;
    }

    public void takePencils(final int pencilsToTake, final String currentPlayer) {
        pencilsLeft -= pencilsToTake;
        nextPlayer = currentPlayer.equals(player1) ? player2 : player1;
    }
}
