import java.util.*;
class Solution {
    private PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    public long solution(int n, int[] works) {
        for(int i = 0 ; i<works.length ; i++){
            pq.add(works[i]);
        }
        while(n>0){
            int curmax = pq.poll();
            if(curmax==0){
                pq.add(curmax);
                break;
            }
            curmax--;
            pq.add(curmax);
            n--;
        }
        return cal();
    }
    private long cal(){
        long result = 0;
        while(!pq.isEmpty()){
            long tmp = pq.poll();
            result+=(tmp*tmp);
        }
        return result;
    }
}