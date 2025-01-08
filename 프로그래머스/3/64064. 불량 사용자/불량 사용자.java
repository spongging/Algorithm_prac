import java.util.*;
class Solution {
    private Set<Set<String>> resultSet = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        boolean visited[] = new boolean[user_id.length];
        dfs(user_id,banned_id,0,visited,new HashSet<>());
        return resultSet.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, int level, boolean visited[], Set<String> currentSet){
        if(level==banned_id.length){
            resultSet.add(new HashSet<>(currentSet));
            return;
        }
        for(int i = 0 ; i<user_id.length ; i++){
            if(!visited[i] && isMatch(banned_id[level], user_id[i])){
                visited[i] = true;
                currentSet.add(user_id[i]);
                dfs(user_id,banned_id,level+1,visited,currentSet);
                visited[i] = false;
                currentSet.remove(user_id[i]);
            }
        }
    }
    
     private boolean isMatch(String banS, String userS) {
        if (banS.length() != userS.length()) return false;
        for (int i = 0; i < banS.length(); i++) {
            if (banS.charAt(i) == '*') continue;
            if (banS.charAt(i) != userS.charAt(i)) return false;
        }
        return true;
    }
}