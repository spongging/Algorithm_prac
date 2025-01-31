import java.util.*;

class Solution {
    private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;
    private boolean[] visited;
    private int visitedNum;
    
    public int solution(int n, int[][] wires) {
        init(n,wires);
        for(int i = 1 ; i <= n ; i++){
            visitedNum = 0;
            visited = new boolean[n+1];
            System.out.println("ignum==>"+i);
            dfs(1,visited,i);
            System.out.println("end//");
            int visitedNum2 = n - 2 - visitedNum;
            System.out.println("visitedNum : "+ visitedNum + "visitedNum2 : "+visitedNum2);
            answer = Math.min(answer, Math.abs(visitedNum - visitedNum2));
            
        }
        return answer;
    }
    
    private void dfs(int idx, boolean[] visited, int igNum){
        visited[idx] = true;
        for(int i = 0 ; i < graph.get(idx).size() ; i++){
            int node = graph.get(idx).get(i);
            
            if(!visited[node] && (igNum!=node)){
                visitedNum++;
                System.out.println(node+"visitedNum:"+visitedNum);
                visited[node] = true;
                dfs(node,visited,igNum);
            }
        }
        return;
    }
    
    private void init(int n, int[][] wires){
        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < wires.length ; i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        return;
    }
}