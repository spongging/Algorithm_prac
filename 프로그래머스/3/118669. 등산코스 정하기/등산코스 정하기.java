import java.util.*;

class Solution {
    private int n;
    private int[][] paths;
    private int[] gates;
    private int[] summits;
    private int[] answer = new int[2];
    private List<Integer> weights;
    private ArrayList<ArrayList<Pair>> graphs = new ArrayList<>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        this.paths = paths;
        this.n = n;
        this.gates = gates;
        this.summits = summits;
        
        getWeights();
        makeGraph();
        binarySearch();
        
        return answer;
    }
    
    private void binarySearch(){
        answer[0] = 0;
        answer[1] = Integer.MAX_VALUE;
        
        int st = 0;
        int ed = weights.size() - 1;
        
        while(st<=ed){
            int mid = (st+ed)/2;
            
            if(bfs(weights.get(mid))){
                ed = mid - 1;
                answer[1] = (int)weights.get(mid);
                
            }else{
                st = mid + 1;
            }
        }
    }
    
    private boolean bfs(int limits){
        boolean flag = false;
        boolean[] visited = new boolean[n+1];
        
        List<Integer> tmpSummits = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int gate : gates){
            q.add(gate);
            visited[gate] = true;
        }
        
        while(!q.isEmpty()){
            int curIdx = q.poll();
            
            if(isSummit(curIdx)){
                tmpSummits.add(curIdx);
                flag = true;
                
                continue;
            }
            
            for(int i = 0 ; i < graphs.get(curIdx).size() ; i++){
                int nextIdx = graphs.get(curIdx).get(i).getIdx();
                int nextWeight = graphs.get(curIdx).get(i).getWeight();
            
                if(!visited[nextIdx]){
                    if(nextWeight<=limits){
                        visited[nextIdx] = true;
                        q.add(nextIdx);
                        
                    }else{
                        continue;
                    }
                }else{
                    continue;
                }
            }
        }
        
        if(flag){
            Collections.sort(tmpSummits);
            answer[0] = tmpSummits.get(0);
        }
        
        return flag;
    }
    
    private boolean isSummit(int curIdx){
        for(int summit : summits){
            if(summit==curIdx){
                return true;
            }
        }
        
        return false;
    }
    
    private void makeGraph(){
        for(int i = 0 ; i <= n ; i++){
            graphs.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < paths.length ; i++){
            graphs.get(paths[i][0]).add(new Pair(paths[i][1], paths[i][2]));
            graphs.get(paths[i][1]).add(new Pair(paths[i][0], paths[i][2]));
        }
    }
    
    private void getWeights(){
        Set<Integer> s = new HashSet<>();
        for(int i = 0 ; i < paths.length ; i++){
            s.add(paths[i][2]);
        }
        
        weights = new ArrayList<>(s);
        Collections.sort(weights);
    }
}

class Pair{
    private int idx;
    private int weight;
    
    public Pair(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }
    
    public int getIdx(){
        return this.idx;
    }
    
    public int getWeight(){
        return this.weight;
    }
}