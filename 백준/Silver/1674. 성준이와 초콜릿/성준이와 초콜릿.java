import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private ArrayList<Integer> queries = new ArrayList<>();
    private ArrayList<Pair> chocolates = new ArrayList<>();
    private ArrayList<Pair> coffees = new ArrayList<>();

    public void solution() throws IOException {
        input();
        for (int T : queries) {
            output(T, getSafeZone(T));
        }
    }

    private void output(int T, double safeZone) {
        System.out.println(T + " " + safeZone);
    }

    private double getSafeZone(int T) {
        double safeZone = 0;

        for (Pair p : chocolates) {
            double n = p.getN();
            int t = p.getT();

            if (t <= T) {
                safeZone += getChocoEffectZone(n, T - t);
            }
        }

        for (Pair p : coffees) {
            double n = p.getN();
            int t = p.getT();

            if (t <= T) {
                safeZone += getCoffeeEffectZone(n, T - t);
            }
        }

        if (safeZone < 1) {
            return 1.0;
        } else {
            double rounded = Math.round(safeZone * 10.0) / 10.0;
            return rounded;
        }
    }

    private double getCoffeeEffectZone(double n, double t) {
        double tmp = 2 * n - (t * t) / 79;

        if (tmp < 0) {
            return 0;
        } else {
            return tmp;
        }
    }

    private double getChocoEffectZone(double n, int t) {
        double tmp = 8 * n - (double) t / 12;

        if (tmp < 0) {
            return 0;
        } else {
            return tmp;
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            String[] token = line.split(" ");
            switch (token[0]) {
                case "Query":
                    queries.add(Integer.parseInt(token[1]));
                    break;
                case "Chocolate":
                    chocolates.add(new Pair(Integer.parseInt(token[1]), Double.parseDouble(token[2])));
                    break;
                case "Coffee":
                    coffees.add(new Pair(Integer.parseInt(token[1]), Double.parseDouble(token[2])));
                    break;
            }
        }

        Collections.sort(queries);
    }
}

class Pair {
    private double n;
    private int t;

    public Pair(int t, double n) {
        this.n = n;
        this.t = t;
    }

    public double getN() {
        return n;
    }

    public int getT() {
        return t;
    }
}