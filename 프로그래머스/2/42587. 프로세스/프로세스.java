import java.util.*;

class Solution {
    private PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
    private Queue<Pair> q = new LinkedList<>();
    
    public int solution(int[] priorities, int location) {
        for(int i = 0 ; i < priorities.length ; i++){
            q.add(new Pair(i,priorities[i]));
            pq.add(priorities[i]);
        }
        
        return execute(priorities, location);
    }
    
    private int execute(int[] priorities, int location){
        int cnt = 0;
        int highNum = pq.poll();
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            if(p.getPriority() == highNum){
                if(!pq.isEmpty()){
                    highNum = pq.poll();
                }
                cnt++;
                if(p.getIdx()==location){
                    return cnt;
                }
            }else{
                q.add(p);
            }
        }
        return cnt;
    }
}

class Pair{
    private int idx;
    private int priority;
    
    public Pair(int idx, int p){
        this.idx = idx;
        this.priority = p;
    }
    
    public int getIdx(){
        return this.idx;
    }
    
    public int getPriority(){
        return this.priority;
    }
}