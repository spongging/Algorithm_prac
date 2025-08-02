import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;

    private final ArrayList<Pair> arr = new ArrayList<>();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            input();
            output(getAnswer());
            t--;
        }
    }

    private int getAnswer() {
        int answer = 1;
        int minB = arr.get(0).getB();

        for (int i = 1; i < N; i++) {
            int tmpB = arr.get(i).getB();

            if (minB > tmpB) {
                minB = tmpB;
                answer++;
            }
        }

        return answer;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        arr.clear();
        N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            arr.add(new Pair(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        arr.sort(Comparator.comparingInt(Pair::getA));
    }
}

class Pair {
    private final int a;
    private final int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}