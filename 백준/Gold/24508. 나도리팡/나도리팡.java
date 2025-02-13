import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solution();
    }
}

class Solution{
    private int N;
    private int K;
    private int T;
    private int[] arr;

    public void solution() throws IOException {
        input();
        System.out.println(isPossible() ? "YES" : "NO");
    }

    private boolean isPossible() {
        int cnt = 0;
        int st = 0;
        int ed = arr.length - 1;

        Arrays.sort(arr);

        while (st <= ed) {
            if (arr[ed] == K) {
                ed--;  
                continue;
            }

            if (arr[st] > 0) {
                arr[st]--;  
                arr[ed]++;  
                cnt++;

                if (cnt > T) {
                    return false;  
                }

                if (arr[ed] == K) {
                    ed--; 
                }

                if (arr[st] == 0) {
                    st++;  
                }
            } else {
                st++;  
            }
        }

        return true;
    }


    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}