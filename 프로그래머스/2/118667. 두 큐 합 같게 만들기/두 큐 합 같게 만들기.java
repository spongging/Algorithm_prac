import java.util.*;

class Solution {
    private long half;
    private long q1Total = 0;
    private long q2Total = 0;
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int size;
    
    public int solution(int[] queue1, int[] queue2) {
        size = queue1.length;
        init(queue1, queue2);
        findHalf(queue1, queue2);
        return func();
    }
    
    private void init(int[] queue1, int[] queue2){
        for(int i = 0 ; i < queue1.length ; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
    }
    
    private void findHalf(int[] queue1, int[] queue2){
        for(int i = 0 ; i < queue1.length ; i++){
            q1Total+=queue1[i];
            q2Total+=queue2[i];
        }
        half = (q1Total+q2Total)/2;
    }
    
    private int func(){
        int answer = 0;
        
        while(!q1.isEmpty() || !q2.isEmpty()){
            if(answer >= 4*size ){
                return -1;
            }
            if(q1Total==half){
                return answer;
            }
            if(q1Total>half){
                int num = q1.poll();
                if(q1.isEmpty()){
                    return -1;
                }
                q1Total-=num;
                q2.add(num);
                answer++;
            }else{
                int num = q2.poll();
                if(q2.isEmpty()){
                    return -1;
                }
                q1Total+=num;
                q1.add(num);
                answer++;
            }
        }
        
        return -1;  
        
    }
    
}