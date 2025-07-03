import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M, X, Y;
    private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private ArrayList<Integer> initInstalls = new ArrayList<>();
    private boolean[] installed;
    private Map<Integer, SysInfo> map = new HashMap<>();

    public void solution() throws IOException {
        inputAndInit();
        bfs();

        if (!isInfinityEarned()) {
            output(getEachSysMoney());
        } else {
            output(-1);
        }
    }

    private long getEachSysMoney() {
        long result = 0;
        ArrayList<Long> arr = new ArrayList<>();

        for (Map.Entry<Integer, SysInfo> entry : map.entrySet()) {
            SysInfo sysInfo = entry.getValue();
            long cost = sysInfo.getCost();
            double time = sysInfo.getTime();

            arr.add(cost * (int) time);
        }

        arr.sort(Comparator.reverseOrder());

        for (int i = 0; i < X; i++) {
            result += arr.get(i);
        }

        return result;
    }

    private void output(long answer) {
        System.out.println(answer);
    }

    private boolean isInfinityEarned() {
        boolean isInfinityEarned = false; // 설치 다 되었냐
        for (int i = 1; i <= N; i++) {
            if (!installed[i] && map.get(i).getCost() > 0) {
                isInfinityEarned = true;
                break;
            }
        }

        return isInfinityEarned;
    }

    private void bfs() {
        Queue<Pair> q = new LinkedList<>();

        for (int num : initInstalls) {
            q.add(new Pair(num, 0.5));
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();

            int curSys = p.getSysNum();
            double curTime = p.getCurTime();

            for (int i = 0; i < graph.get(curSys).size(); i++) {
                int nextSys = graph.get(curSys).get(i);

                if (!installed[nextSys]) {
                    installed[nextSys] = true;
                    map.get(nextSys).setTime(curTime + 1.0);
                    q.add(new Pair(nextSys, curTime + 1.0));
                }
            }
        }
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        X = Integer.parseInt(line[2]);
        Y = Integer.parseInt(line[3]);

        line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            map.put(i + 1, new SysInfo(Integer.parseInt(line[i]), 0));
        }

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");

            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        line = br.readLine().split(" ");
        for (int i = 0; i < Y; i++) {
            initInstalls.add(Integer.parseInt(line[i]));
        }

        installed = new boolean[N + 1];
        installed[0] = true;

        for (int i = 0; i < Y; i++) {
            installed[initInstalls.get(i)] = true;
        }
    }
}

class SysInfo {
    private long cost;
    private double time;

    public SysInfo(long cost, double time) {
        this.cost = cost;
        this.time = time;
    }

    public long getCost() {
        return cost;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}

class Pair {
    int sysNum;
    double curTime;

    public Pair(int sysNum, double curTime) {
        this.sysNum = sysNum;
        this.curTime = curTime;
    }

    public int getSysNum() {
        return sysNum;
    }

    public double getCurTime() {
        return curTime;
    }
}