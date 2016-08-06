package MyClass;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Владимир on 06.08.2016.
 */
public final class XOGames {
    private byte[][] field;
    private int lengthFieldX;
    private int lengthFieldY;
    private Random rand = new Random();

    public XOGames(int lengthFieldX, int lengthFieldY) {
        this.lengthFieldX = lengthFieldX;
        this.lengthFieldY = lengthFieldY;
        field = new byte[lengthFieldY+1][lengthFieldX+1];
        for (int i = 0; i < lengthFieldY+1; i++) {
            Arrays.fill(field[i], (byte) 0);
        }
    }

    private boolean isCellInspection(int x, int y) {

        if ((x >= lengthFieldY) || (y >= lengthFieldX)) return true;
        switch (field[x][y]) {
            case 1:
                System.out.println("Клетка уже занята - ход игрока");
                return true;
            case -1:
                System.out.println("Клетка уже занята - ход компьютура");
                return true;
            default:
                return false;
        }
    }

    public boolean humanTurn(int x, int y) {

        if (!isCellInspection(y, x)) {
            field[y][x] = 1;
            field[y][lengthFieldX]++;
            field[lengthFieldY][x]++;
            return true;
        }
        return false;
    }

    public void aiTurn() {
        int x, y;

        if (movesResidue() == 0) return;
            do {

                x = rand.nextInt(lengthFieldX);
                y = rand.nextInt(lengthFieldY);

            } while (isCellInspection(y, x));
            field[y][x] = -1;
    }

    public byte cellValue(int x, int y){
        return field[y][x];
    }

    public void printField() {
        //Выводим поле на экран

        for (int i = 0; i < lengthFieldY+1; i++) {
            for (int j = 0; j < lengthFieldX+1; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int movesResidue(){
        int res = 0;
        for (int i = 0; i < lengthFieldY; i++) {
            for (int j = 0; j < lengthFieldX; j++) {
                if (field[i][j] == 0) res++;
            }
        }

        return res;
    }
}


