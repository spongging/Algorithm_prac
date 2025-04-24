import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int T;
    private int N;
    private int M;
    private ArrayList<Pair> arr;
    private Map<Integer, ArrayList<Integer>> map;
    private ArrayList<Pair> resultArr;
    private ArrayList<Integer> queryList;

    public void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new ArrayList<>(N);

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                arr.add(new Pair(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            }

            String[] line = br.readLine().split(" ");
            M = Integer.parseInt(line[0]);
            queryList = new ArrayList<>();

            for (int i = 1; i <= M; i++) {
                queryList.add(Integer.parseInt(line[i]));
            }

            arr.add(new Pair(-1, 0));
            arr.sort(Comparator.comparingInt(Pair::getX)
                    .thenComparingInt(Pair::getY));

            map = new LinkedHashMap<>();
            for (Pair p : arr) {
                map.computeIfAbsent(p.getX(), k -> new ArrayList<>())
                        .add(p.getY());
            }

            resultArr = new ArrayList<>();
            int lastY = 0;

            for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
                int x = e.getKey();
                ArrayList<Integer> values = e.getValue();

                if (x == -1) {
                    continue;
                }

                if (lastY != values.get(0)) {
                    Collections.reverse(values);
                }

                for (int v : values) {
                    resultArr.add(new Pair(x, v));
                }

                lastY = values.get(values.size() - 1);
            }

            //정답 도출
            for (int idx : queryList) {
                Pair tmpP = resultArr.get(idx - 1);
                System.out.println(tmpP.getX() + " " + tmpP.getY());
            }

            T--;
        }
    }
}

class Pair{
    private final int X;
    private final int Y;

    public Pair(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
