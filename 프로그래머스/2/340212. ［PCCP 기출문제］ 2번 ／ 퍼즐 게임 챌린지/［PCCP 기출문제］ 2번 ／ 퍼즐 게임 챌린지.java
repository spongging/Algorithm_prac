import java.util.*;

class Solution {
    private static int answer = Integer.MAX_VALUE;
    
    public int solution(int[] diffs, int[] times, long limit) {
        binarySearch(diffs, times, limit);
        return answer;
    }
    
    private void binarySearch(int[] diffs, int[] times, long limit){
        int st = 1;
        int ed = findMax(diffs);
        
        while(st<=ed){
            int mid = (st + ed) / 2;
            long time = findTime(diffs, times, mid);
            
            if(time<=limit){
                answer = Math.min(answer, mid);
                ed = mid - 1;
            }else{
                st = mid + 1;
            }
        }
    }
    
    private long findTime(int[] diffs, int[] times, int level){
        int prevTime = 0;
        long result = 0;
        
        for(int i = 0 ; i < times.length ; i++){
            if(diffs[i] <= level){
                result += times[i]; 
            }else{
                result += (prevTime + times[i]) * (diffs[i] - level) + times[i];
            }
            prevTime = times[i];
        }
        
        return result;
    }
    
    private int findMax(int[] diffs){
        int tmp = 0;
        for(int num : diffs){
            tmp = Math.max(num, tmp);
        }
        
        return tmp;
    }
}


