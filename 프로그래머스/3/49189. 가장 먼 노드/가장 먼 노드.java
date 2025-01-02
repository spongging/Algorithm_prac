import java.util.*;
class Solution {
    
    private ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
    private boolean[] visited;
    public int solution(int n, int[][] edge) {
        
        visited = new boolean[n+1];
        for(int i = 0; i <= n ; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i<edge.length ; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        return bfs(1);
    }
    private int bfs(int node){
        
        int max = 0;
        int cnt = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{node,0});
        visited[node] = true;
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int curNode = cur[0];
            int curLevel = cur[1];
            
            if(max<curLevel){
                    max = curLevel;
                    cnt = 1;
                }
            else if(max==curLevel) cnt++;
            
            for(int i = 0 ; i<graph.get(curNode).size() ; i++){
                int next = graph.get(curNode).get(i);
              
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next,curLevel+1});
                }
            }
        }
        return cnt;
    }
}