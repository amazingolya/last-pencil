package lastpencil;

public class Errors {
    public void notNumericString() {
        System.out.println("The number of pencils should be numeric");
    }

    public void zeroPencils() {
        System.out.println("The number of pencils should be positive");
    }

    public void wrongPlayerName(final String player1, final String player2) {
        System.out.printf("Choose between '%s' and '%s'\n", player1, player2);
    }

    public void wrongPencilsNumber() {
        System.out.println("Possible values: '1', '2' or '3'");
    }

    public void tooManyPencils() {
        System.out.println("Too many pencils were taken");
    }
}
