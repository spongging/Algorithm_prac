import java.util.*;
class Solution {
    private static long answer = Long.MAX_VALUE;
    public long solution(int n, int[] times) {
        binarySearch(n,times,0,findMax(times)*n);
        return answer;
    }
    
    private long findMax(int[] times){
        Arrays.sort(times);
        return times[times.length-1];
    }
    
    private void binarySearch(int n , int[] times, long left, long right ){
        while(left<=right){
            long mid = (left+right)/2;
            long cntPerson = countingPerson(times, mid);
            if( cntPerson>=n){
                answer = Math.min(answer,mid);
                right = mid-1;
            }
            else left = mid+1;
        }
    }
    
    private long countingPerson(int[] times, long mid){
        long tmp = 0;
        for(int i = 0 ; i < times.length ; i++){
            tmp+=mid/times[i];
        }
        return tmp;
    }
}