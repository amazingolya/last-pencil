package lastpencil;

public class InputChecker {
    Errors errors = new Errors();

    public boolean checkTotalPencils(final String input) {
        if (nullOrNonNumeric(input)) {
            errors.notNumericString();
            return false;
        }
        if (input.equals("0")) {
            errors.zeroPencils();
            return false;
        }
        return true;
    }

    public boolean checkPlayerName(final String input, final Game game) {
        String player1 = game.getPlayer1();
        String player2 = game.getPlayer2();
        if (!input.equals(player1) && !input.equals(player2)) {
            errors.wrongPlayerName(player1, player2);
            return false;
        }
        return true;
    }

    public boolean checkPencilsToTake(final String input, final int pencilsOnTable) {
        if (nullOrNonNumeric(input)) {
            errors.wrongPencilsNumber();
            return false;
        }
        int pencilsToTake = Integer.parseInt(input);
        if (pencilsToTake != 1 && pencilsToTake != 2 && pencilsToTake != 3) {
            errors.wrongPencilsNumber();
            return false;
        }
        if (pencilsToTake > pencilsOnTable) {
            errors.tooManyPencils();
            return false;
        }
        return true;
    }

    private boolean nullOrNonNumeric(final String input) {
        return input == null || !input.matches("[0-9]+");
    }
}
