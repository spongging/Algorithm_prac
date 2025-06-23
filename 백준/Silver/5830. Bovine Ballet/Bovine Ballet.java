import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N;
    private final ArrayList<String> querys = new ArrayList<>();
    private Map<String, Pair> map = new HashMap<>();
    private int maxX = 1;
    private int maxY = 1;
    private int minX = 0;
    private int minY = 0;
    private int dir = 0;
    private boolean flag = true;

    public void solution() throws IOException {
        input();

        for (String query : querys) {
            if (!executeQuery(query)) {
                flag = false;
                break;
            }
        }

        output();
    }

    private void output() {
        if (flag) {
            System.out.println((maxX - minX + 1) * (maxY - minY + 1));
        } else {
            System.out.println(-1);
        }
    }

    private boolean executeQuery(String query) {
        String pivot = query.substring(0, 2);
        char movement = query.charAt(2);

        Pair pair = map.get(pivot);

        int pivotA = pair.getA();
        int pivotB = pair.getB();

        if (movement == 'F') {
            if (dir == 0) {
                pair.setA(pivotA + 1);

            } else if (dir == 1) {
                pair.setB(pivotB + 1);

            } else if (dir == 2) {
                pair.setA(pivotA - 1);

            } else {
                pair.setB(pivotB - 1);
            }

        } else if (movement == 'B') {
            if (dir == 0) {
                pair.setA(pivotA - 1);

            } else if (dir == 1) {
                pair.setB(pivotB - 1);

            } else if (dir == 2) {
                pair.setA(pivotA + 1);

            } else {
                pair.setB(pivotB + 1);
            }

        } else if (movement == 'R') {
            if (dir == 0) {
                pair.setB(pivotB + 1);

            } else if (dir == 1) {
                pair.setA(pivotA - 1);

            } else if (dir == 2) {
                pair.setB(pivotB - 1);

            } else {
                pair.setA(pivotA + 1);
            }

        } else if (movement == 'L') {
            if (dir == 0) {
                pair.setB(pivotB - 1);

            } else if (dir == 1) {
                pair.setA(pivotA + 1);

            } else if (dir == 2) {
                pair.setB(pivotB + 1);

            } else {
                pair.setA(pivotA - 1);
            }
        } else {
            dir = (dir + 1) % 4;

            for (Map.Entry<String, Pair> entry : map.entrySet()) {
                if (entry.getKey().equals(pivot)) {
                    continue;
                }

                int da = pivotA - entry.getValue().getA();
                int db = pivotB - entry.getValue().getB();

                entry.getValue().setB(pivotB - da);
                entry.getValue().setA(pivotA + db);
            }
        }

        getMinAndMaxCord();
        return !checkFallDown();
    }

    private void getMinAndMaxCord() {
        for (Map.Entry<String, Pair> entry : map.entrySet()) {
            int a = entry.getValue().getA();
            int b = entry.getValue().getB();

            maxX = Math.max(maxX, b);
            maxY = Math.max(maxY, a);
            minX = Math.min(minX, b);
            minY = Math.min(minY, a);
        }
    }

    private boolean checkFallDown() {
        Set<Pair> s = new HashSet<>();

        for (Pair p : map.values()) {
            if (!s.add(p)) {
                return true;
            }
        }

        return false;
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            querys.add(s);
        }

        map.put("FL", new Pair(1, 0));
        map.put("FR", new Pair(1, 1));
        map.put("RL", new Pair(0, 0));
        map.put("RR", new Pair(0, 1));
    }
}

class Pair {
    private int a;
    private int b;

    public Pair(int i, int i1) {
        this.a = i;
        this.b = i1;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}
