import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution {
    private int N, M;

    private final Map<String, ArrayList<String>> map = new HashMap<>();
    private final Map<String, String> map2 = new HashMap<>();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void solution() throws IOException {
        inputAndInit();

        while (M > 0) {
            String name = br.readLine().trim();
            int type = Integer.parseInt(br.readLine().trim());

            if (type == 0) {
                for (String memberName : map.get(name)) {
                    System.out.println(memberName);
                }
            } else {
                System.out.println(map2.get(name));
            }

            M--;
        }
    }

    private void inputAndInit() throws IOException {
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        for (int i = 0; i < N; i++) {
            String groupName = br.readLine().trim();
            int size = Integer.parseInt(br.readLine().trim());

            for (int j = 0; j < size; j++) {
                String memberName = br.readLine().trim();

                map.putIfAbsent(groupName, new ArrayList<>());
                map.get(groupName).add(memberName);
                map2.put(memberName, groupName);
            }
        }

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            ArrayList<String> value = entry.getValue();
            Collections.sort(value);
        }
    }
}