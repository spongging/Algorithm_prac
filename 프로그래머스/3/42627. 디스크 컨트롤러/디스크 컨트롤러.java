import java.util.*;
class Solution {
    private PriorityQueue<Job> pq = new PriorityQueue<>((job1,job2)->{
        if(job1.getRunTime()!=job2.getRunTime()) return Integer.compare(job1.getRunTime(),job2.getRunTime());
        else if(job1.getRequestTime()!=job2.getRequestTime()) return Integer.compare(job1.getRequestTime(),job2.getRequestTime());
        else return Integer.compare(job1.getIdx(),job2.getIdx());
    });
    private int[] returnTimeArr;
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs,Comparator.comparingInt(job->job[0]));
        returnTimeArr = new int[jobs.length];
        
        discController(jobs);
        return getAvgReturnTime(returnTimeArr);
    }
    
    private void discController(int[][] jobs){
        int time = 0;
        int jobIdx = 0;
        while(jobIdx<jobs.length || !pq.isEmpty()){
            while(jobIdx<jobs.length && jobs[jobIdx][0]<=time){
                pq.add(new Job(jobIdx, jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx++;
            }
            if(!pq.isEmpty()){
                Job tmpJob = pq.poll();
                int tmpIdx = tmpJob.getIdx();
                int tmpRequestTime = tmpJob.getRequestTime();
                int tmpRunTime = tmpJob.getRunTime();
                time+=tmpRunTime;
                returnTimeArr[tmpIdx] = time-tmpRequestTime;
            }
            else{
                time++;
            }
        }
    }
    private int getAvgReturnTime(int[] returnTimeArr){
        int sum = 0;
        for(int num : returnTimeArr){
            sum+=num;
        }
        return sum/returnTimeArr.length;
    }
}

class Job{
    private int idx;
    private int requestTime;
    private int runTime;
    
    public Job(int idx, int requestTime, int runTime){
        this.idx = idx;
        this.requestTime = requestTime;
        this.runTime = runTime;
    }
    public int getIdx() {return this.idx;}
    public int getRequestTime() {return this.requestTime;}
    public int getRunTime() {return this.runTime;}
}