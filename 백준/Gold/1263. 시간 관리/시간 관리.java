import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private ArrayList<Pair> arr = new ArrayList<>();
    private int curTime = 0;

    public void solution() throws IOException {
        input();
        working();
        output();
    }

    private void output() {
        System.out.println(Math.max(-1, curTime));
    }

    private void working() {
        for (int i = 0; i < arr.size(); i++) {
            if (curTime <= arr.get(i).getS()) {
                curTime -= arr.get(i).getT();
            } else {
                curTime = arr.get(i).getS();
                curTime -= arr.get(i).getT();
            }
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            arr.add(new Pair(Integer.parseInt(line[0]), Integer.parseInt(line[1])));

            curTime = Math.max(curTime, Integer.parseInt(line[1]));
        }

        arr.sort((a, b) -> Integer.compare(b.getS(), a.getS()));
    }
}

class Pair{
    private int T;
    private int S;

    public Pair(int t, int s) {
        T = t;
        S = s;
    }

    public int getT() {
        return T;
    }

    public int getS() {
        return S;
    }
}