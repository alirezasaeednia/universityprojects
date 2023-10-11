package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) throws StackOverflowError {
        Scanner scanner = new Scanner(System.in);
        int points = scanner.nextInt();
        int lines = scanner.nextInt();
        Geraph geraph = new Geraph(points, lines);
        geraph.setList(scanner);
//        System.out.println(Arrays.deepToString(geraph.getList()));
        ArrayList<Engine> engines = new ArrayList<>();
        for (int i = 0; i < points; i++) {
            engines.add(new Engine(geraph, i + 1));
            engines.get(i).run();
        }
//        System.out.println(engines.get(0).getMin() + "mmqqm");
        engines.sort(Comparator.comparing(Engine::getMin));
//        for (int i = 0; i < points; i++) {
//            System.out.println(engines.get(i).getPoint()+" "+engines.get(i).getMin());
//        }
        if (engines.get(0).getMin() == 9999) {
            System.out.println("No orbit found");
        } else {
            System.out.println(engines.get(0).getMin());
        }

    }
}

