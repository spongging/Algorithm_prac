import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int answer = 0;

    private final ArrayList<Bag> bags = new ArrayList<>();

    public void solution() throws IOException {
        input();

        for (Bag b : bags) {
            if (isPossible(b)) {
                output(1);
                answer++;
            } else {
                output(0);
            }
        }
        output(answer);
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private boolean isPossible(Bag bag) {
        double a = bag.getA();
        double b = bag.getB();
        double c = bag.getC();
        double weight = bag.getWeight();

        if (weight > 7) {
            return false;
        }

        if (a + b + c > 125) {
            if (a + b + c == 126) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        } 
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] line = br.readLine().split("\\s+");

            bags.add(new Bag(
                    Double.parseDouble(line[0]),
                    Double.parseDouble(line[1]),
                    Double.parseDouble(line[2]),
                    Double.parseDouble(line[3])
            ));
        }
    }
}

class Bag {
    private final double a;
    private final double b;
    private final double c;
    private final double weight;

    public Bag(double a, double b, double c, double weight) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.weight = weight;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getWeight() {
        return weight;
    }
}