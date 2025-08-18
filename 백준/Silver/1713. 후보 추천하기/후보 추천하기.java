import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;

    private final ArrayList<Integer> queries = new ArrayList<>();
    private final ArrayList<Integer> photos = new ArrayList<>();
    private final Map<Integer, Pair> map = new HashMap<>();

    public void solution() throws IOException {
        input();
        getAnswer();
        output();
    }

    private void output() {
        for (int num : photos) {
            System.out.print(num + " ");
        }
    }

    private void getAnswer() {
        int curTime = 0;

        for (int q : queries) {
            curTime++;

            if (photos.contains(q)) {
                map.put(q, new Pair(map.get(q).getTime(), map.get(q).getCnt() + 1));
                continue;
            }

            if (photos.size() < N) {
                photos.add(q);
                map.putIfAbsent(q, new Pair(curTime, 1));

            } else {
                boolean isCntSame = false;
                int tmpMinCnt = Integer.MAX_VALUE;
                int tmpMinCntKey = 0;

                ArrayList<Integer> sameCntArr = new ArrayList<>();

                for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
                    int key = entry.getKey();
                    int cnt = entry.getValue().getCnt();

                    if (tmpMinCnt > cnt) {
                        sameCntArr.clear();
                        sameCntArr.add(key);

                        tmpMinCnt = cnt;
                        tmpMinCntKey = key;

                        isCntSame = false;

                    } else if (tmpMinCnt == cnt) {
                        sameCntArr.add(key);
                        isCntSame = true;
                    }
                }

                if (!isCntSame) {
                    map.remove(tmpMinCntKey);
                    map.put(q, new Pair(curTime, 1));
                    photos.remove(Integer.valueOf(tmpMinCntKey));
                    photos.add(q);

                } else {
                    int lastTime = Integer.MAX_VALUE;
                    int lastTimeKey = 0;

                    for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
                        if (!sameCntArr.contains(entry.getKey())) {
                            continue;
                        }

                        int key = entry.getKey();
                        int time = entry.getValue().getTime();

                        if (time < lastTime) {
                            lastTime = time;
                            lastTimeKey = key;
                        }
                    }

                    map.remove(lastTimeKey);
                    map.put(q, new Pair(curTime, 1));

                    photos.remove(Integer.valueOf(lastTimeKey));
                    photos.add(q);
                }
            }
        }

        Collections.sort(photos);
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        M = Integer.parseInt(br.readLine().trim());

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            queries.add(Integer.parseInt(line[i]));
        }
    }
}

class Pair {
    private final int time;
    private final int cnt;

    public Pair(int time, int cnt) {
        this.time = time;
        this.cnt = cnt;
    }

    public int getTime() {
        return time;
    }

    public int getCnt() {
        return cnt;
    }
}