import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}

class Solution{
    private String s;
    private final ArrayList<Character> arr = new ArrayList<>();

    public void solution() throws IOException{
        input();
        output(getAnswer());
    }

    private int getAnswer(){
        int cnt = 0;
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++ ) {
            char c = arr.get(i);

            if (c=='('){
               st.push(c);
                
            } else {
                if(arr.get(i-1) == '('){
                    st.pop();
                    cnt += st.size();
                }else {
                    cnt+=1;
                    st.pop();
                }
            }
        }

        return cnt;
    }

    private void output(int answer){
        System.out.println(answer);
    }

    private void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        for (int i = 0 ; i < s.length() ; i++) {
            arr.add(s.charAt(i));
        }
    }
}