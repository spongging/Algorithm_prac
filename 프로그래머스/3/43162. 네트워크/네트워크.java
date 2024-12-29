import java.util.*;
class Solution {
    int[] parents;
    public int solution(int n, int[][] computers) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i<n ; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i<computers.length ; i++){
            for(int j = 0 ; j<computers[i].length ; j++){
                if(computers[i][j]==0) continue;
                graph.get(i).add(j);
            }
        }
        
        parents = new int[n];
        init(n);
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<graph.get(i).size() ; j++){
                Union(i,graph.get(i).get(j));  
            }
        }
        
        return findNet(parents);
    }
    
    private void init(int n){
        for(int i = 0 ; i < n ; i++){
            parents[i] = i;
        }
    }
    
    private int find(int x){
        if(x==parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }
    
    private void Union(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y) return;
        if(x<y) parents[y] = x;
        else parents[x] = y;
        return;
    }
    
    private int findNet(int[] parents){
        Set<Integer> s = new HashSet<>();
        for(int i = 0 ; i<parents.length ; i++){
            s.add(find(i));
        }
        return s.size();
    }
    
}
