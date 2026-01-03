import java.util.*;

class Solution {
    private final static Queue<Integer>q1 = new LinkedList<>();
    private final static Queue<Integer>q2 = new LinkedList<>();
    private final static ArrayList<Integer> resultArr = new ArrayList<>();
    private static boolean flag = false; 
    private static int N;
    
    public int[] solution(int[] progresses, int[] speeds) {
        init(progresses, speeds);
        while(!q1.isEmpty()){
            working();
            int cnt = publishing();
            
            if(cnt>0) resultArr.add(cnt);
        }
        
        return output();
    }
    
    public int[] output(){
        int size = resultArr.size();
        int[] answer = new int[size];
        
        for(int i = 0  ; i < size ; i++){
            answer[i] = resultArr.get(i);
        }
        
        return answer;
    }
    
    public int publishing(){
        int cnt = 0;
        for(int i = 0 ; i < N ; i++){
            int val = q1.peek();
            if(val<100) break;
            
            cnt++;
            q1.poll();
            q2.poll();
        }
        N-=cnt;
        
        return cnt;
    }
    
    public void working(){
        for(int i = 0 ; i < N ; i++){
            int val = q1.poll();
            int val2 = q2.poll();
            
            int nval = val + val2;
            q1.add(nval);
            q2.add(val2);
        }
    }
    
    public void init(int[] progresses, int[] speeds){
        N = progresses.length;
        
        for(int num : progresses){
            q1.add(num);
        }
        
        for(int num : speeds){
            q2.add(num);
        }
    }
}