import java.util.*;
//자바 7,8번 억까 아닌가?
class Solution {
    private static long answer;
    
    private static long[] arr;
    private static boolean[] visited;
    private static List<Integer>[] graph;
    
    public long solution(int[] a, int[][] edges) {
        init(a, edges);
        
        if(!isPossible()){
            return -1;
        }
        
        dfs(0);
        
        return answer;
        
    }
    
    private long dfs(int idx){
        visited[idx] = true;
        
        for (int i = 0 ; i < graph[idx].size() ; i++){
            int next = graph[idx].get(i);
            
            if(!visited[next]){
                arr[idx] += dfs(next);   
            }
        }
        
        long tmp = arr[idx];
        answer += Math.abs(tmp);
        
        return tmp;
    }
    
    private void init(int[] a, int[][] edges){
        answer = 0;
        arr = new long[a.length];
        visited = new boolean[a.length];
        graph = new ArrayList[a.length];
        
        for (int i = 0 ; i < a.length ; i++){
            arr[i] = a[i];
        }
        
        for (int i = 0 ; i < a.length ; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0 ; i < edges.length ;i++){
            graph[edges[i][0]].add(edges[i][1]);
	    	graph[edges[i][1]].add(edges[i][0]);
        }
    }
    
    private boolean isPossible(){
        long tmp = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            tmp += arr[i];
        }
        
        return tmp == 0 ? true : false;
    }
}