import java.util.*;

class Solution {
    private static int answer = 0;
    private ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    private boolean visited[];
    public int solution(int n, int[][] lighthouse) {
        for(int i = 0 ; i <= n ; i++){
            map.add(new ArrayList<Integer>());
        }
        for(int i = 0 ; i < lighthouse.length ; i++){
            map.get(lighthouse[i][0]).add(lighthouse[i][1]);                                     map.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        
        visited = new boolean[n+1];
        visited[1] = true;
        
        dfs(1);
        return answer;
        
    }
    
    private int dfs(int idx){
        if(map.get(idx).size()==0) {
            return 1;
        }
        int tmp = 0;
        
        for(int i = 0 ; i<map.get(idx).size() ; i++){
            int next = map.get(idx).get(i);
            if(visited[next]) continue;
            visited[next] = true;
            tmp+=dfs(next);
        }
        
        if(tmp>=1){
            answer++;
            return 0;
        }
        else{
            return 1;
        }
    }
}