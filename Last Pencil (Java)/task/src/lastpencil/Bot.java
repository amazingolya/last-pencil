package lastpencil;

public class Bot {
    private final String name;

    public Bot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPencils(final int pencilsOnTable) {
        int temp = pencilsOnTable;
        do {
            if (temp <= 2 || temp == 5) {
                return  1;
            }
            if (temp == 3) {
                return  2;
            }
            if (temp == 4) {
                return 3;
            }
            temp -= 4;
        } while (true);
    }
}
