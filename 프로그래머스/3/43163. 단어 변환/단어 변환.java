import java.util.*;
class Solution {
    private Integer size;
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;
        size = words.length;
        return bfs(begin,target,words);
    }
    
    private int bfs(String begin, String target, String[] words){
        Queue<WordP> q = new LinkedList<>();
        boolean visited[] = new boolean[size];
        q.add(new WordP(begin,0));
        
        while(!q.isEmpty()){
            WordP wp = q.poll();
            String str = wp.getStr();
            int cnt = wp.getCnt();
            
            if(str.equals(target)) return cnt;
            for(int i = 0 ; i<words.length ; i++){
                if(visited[i]) continue;
                if(isPossible(str,words[i])){
                    visited[i] = true;
                    q.add(new WordP(words[i],cnt+1));
                }
            }
            
        }
        return 0;
    }
    
    public boolean isPossible(String str1, String str2){
        int diffCnt = 0;
        for(int i = 0 ; i< str1.length() ; i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                diffCnt++;
            }
        }
        if(diffCnt==1) return true;
        else return false;
    }
    
   
}

class WordP{
    
    String str;
    int cnt;
    
    public WordP(String str, int cnt){
        this.str = str;
        this.cnt = cnt;
    }
    
    public String getStr(){
        return this.str;
    }
    
    public int getCnt(){
        return this.cnt;
    }
}