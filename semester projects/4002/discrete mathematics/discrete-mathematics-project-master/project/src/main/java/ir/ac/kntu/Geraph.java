package ir.ac.kntu;

import java.util.*;

public class Geraph {

    private Boolean[][] list;

    private int lines;

    public Geraph(Boolean[][] list) {
        this.list = list;
    }

    public Geraph(Boolean[][] list, int lines) {
        this.list = list;
        this.lines = lines;
    }

    public Geraph(int points, int lines) {
        list = new Boolean[points][points];
        this.lines = lines;
        for (int i = 0; i < points; i++) {
            for (int j = 0; j < points; j++) {
                list[i][j] = false;
            }
        }
    }

    public void setList(Scanner scanner) {
        for (int i = 0; i < lines; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            list[m - 1][n - 1] = true;
            list[n - 1][m - 1] = true;
        }
    }

    public Boolean[][] getList() {
        return list;
    }

    public void setList(Boolean[][] list) {
        this.list = list;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }
}
