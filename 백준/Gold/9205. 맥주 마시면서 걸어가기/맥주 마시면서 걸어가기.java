import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private boolean flag;
    private int houseX, houseY;
    private int festivalX, festivalY;
    private ArrayList<Pair> convCoors;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        while (t > 0) {
            input();
            bfs(houseX, houseY, festivalX, festivalY);
            output(flag);
            t--;
        }
    }

    private void bfs(int houseX, int houseY, int festivalX, int festivalY) {
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[N];

        q.add(new Pair(houseX, houseY));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();

            if (check(aa, bb, festivalX, festivalY)) {
                flag = true;
                return;
            }

            for (int i = 0; i < N; i++) {
                Pair convP = convCoors.get(i);
                int na = convP.getA();
                int nb = convP.getB();

                if (!visited[i] && check(aa, bb, na, nb)) {
                    visited[i] = true;
                    q.add(new Pair(na, nb));
                }
            }
        }

        flag = false;
    }


    private boolean check(int curA, int curB, int targetX, int targetY) {
        int tmp = Math.abs(curA - targetX) + Math.abs(curB - targetY);

        return tmp <= 1000;
    }

    private void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        convCoors = new ArrayList<>();

        String[] houseLine = br.readLine().split(" ");
        houseX = Integer.parseInt(houseLine[0]);
        houseY = Integer.parseInt(houseLine[1]);

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            convCoors.add(new Pair(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        String[] line = br.readLine().split(" ");
        festivalX = Integer.parseInt(line[0]);
        festivalY = Integer.parseInt(line[1]);

        flag = false;
    }

    private void output(boolean flag) {
        if (flag) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }
    }
}

class Pair {
    private int a;
    private int b;

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


