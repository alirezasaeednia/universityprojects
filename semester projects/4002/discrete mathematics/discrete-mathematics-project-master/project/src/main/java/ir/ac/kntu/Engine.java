package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Engine implements Runnable {

    private Geraph geraph;

    private Integer min = 0;

    private Integer point;

    private Boolean stop = false;

    private HashMap<Boolean[], Integer> skip = new HashMap<>();

    public Engine(Geraph geraph, Integer point) {
        this.geraph = geraph;
        this.point = point;
    }

    public void setSkip() {
        for (int i = 0; i < geraph.getList().length; i++) {
            skip.put(geraph.getList()[i], i);
        }
    }

    public Geraph getGeraph() {
        return geraph;
    }

    public void setGeraph(Geraph geraph) {
        this.geraph = geraph;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public void goThrough(int skip, int point, Boolean[] lines) {
        min++;
        for (int i = 0; i < lines.length; i++) {
//            System.out.println(lines[i]);
            if (lines[i] && i != skip) {
//                System.out.println(skip + " " + point + " " + i);
                if (i == point) {
                    stop = true;
//                    System.out.println("min issss for point" + point + " " + min);
                    return;
                } else if (!stop && min < geraph.getLines() * 2) {
//                    System.out.println("meo");
                    goThrough(this.skip.get(lines), point, geraph.getList()[i]);
                }
            }
        }
    }

    @Override
    public void run() {
        Boolean[] lines = geraph.getList()[point - 1];
        ArrayList<Integer> mins = new ArrayList<>();
        setSkip();
        for (int i = 0; i < lines.length; i++) {
//            System.out.println(lines[i]);
            if (lines[i]) {
                this.min++;
                goThrough(point - 1, point - 1, geraph.getList()[i]);
                if (stop) {
                    mins.add(min);
                    stop = false;
                }
                this.min = 0;
            }
        }
        mins.sort(Comparator.naturalOrder());
        try {
            this.min = mins.get(0);
        } catch (Exception ignored) {
            this.min = 9999;
        }
//        System.out.println(mins);
    }
}
