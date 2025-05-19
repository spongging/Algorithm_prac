import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Pair> arr = new ArrayList<>();

    public void solution() throws IOException {
        input();
        output(getTime());
    }

    private int getTime() {
        int lastTime = getLastTime();

        for (Pair p : arr) {
            int dd = p.getD();
            int tt = p.getT();

            if (lastTime > tt) {
                lastTime = tt - dd;
            } else {
                lastTime = lastTime - dd;
            }
        }

        return lastTime;
    }

    private int getLastTime() {
        int tmp = 0;

        for (Pair p : arr) {
            tmp = Math.max(tmp, p.getT());
        }

        return tmp;
    }

    private void output(int answer) {
        System.out.println(answer);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            arr.add(new Pair(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        arr.sort((a, b) -> Integer.compare(b.getT(), a.getT()));
    }

}

class Pair {
    private int d;
    private int t;

    public Pair(int d, int t) {
        this.d = d;
        this.t = t;
    }

    public int getD() {
        return d;
    }

    public int getT() {
        return t;
    }
}