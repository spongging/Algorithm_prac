import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M, root;

    private boolean[] blocked;
    private final ArrayList<Integer> leafNodeIdx = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void solution() throws IOException {
        inputAndInit();
        searchBlocked(M);
        if(!blocked[root]) searchTree(root);
        output();
    }

    private void output() {
        System.out.println(leafNodeIdx.size());
    }

    private void searchTree(int idx) {
        if (checkLeafNode(idx)) {
            leafNodeIdx.add(idx);
            return;
        }

        for (int i = 0; i < graph.get(idx).size(); i++) {
            int next = graph.get(idx).get(i);

            if (!blocked[next]) {
                searchTree(next);
            }
        }
    }

    private boolean checkLeafNode(int idx) {
        if (graph.get(idx).isEmpty()) return true;

        for (int i = 0; i < graph.get(idx).size(); i++) {
            int node = graph.get(idx).get(i);

            if (!blocked[node]) return false;
        }

        return true;
    }

    private void searchBlocked(int idx) {
        for (int i = 0; i < graph.get(idx).size(); i++) {
            int next = graph.get(idx).get(i);
            blocked[next] = true;
            searchBlocked(next);
        }
    }

    private void inputAndInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        String[] line = br.readLine().split(" ");
        root = -1;

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(line[i]);
            if (p == -1) {
                root = i;
            } else graph.get(p).add(i);
        }

        M = Integer.parseInt(br.readLine().trim());

        blocked = new boolean[N];
        blocked[M] = true;
    }
}