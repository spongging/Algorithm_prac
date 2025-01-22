import java.util.*;

class Solution {
    private Map<String, ArrayList<Pair>> map = new HashMap<>();
    private boolean[] visited;
    private ArrayList<String> visitedName = new ArrayList<>();
    private String[] answer;
    private int size;
    private boolean isSolved = false;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        size = tickets.length;
        
        for(int i = 0 ; i < tickets.length ; i++){
            if(map.containsKey(tickets[i][0])){
                map.get(tickets[i][0]).add(new Pair(tickets[i][1],i));
            }else{
                map.put(tickets[i][0], new ArrayList<Pair>());
                map.get(tickets[i][0]).add(new Pair(tickets[i][1],i));
            }
        }
        
        for(String key : map.keySet()){
            ArrayList<Pair> list = map.get(key);
            list.sort(Comparator.comparing(Pair::getName));
        }
        
        visitedName.add("ICN");
        dfs("ICN",0);
        
        return answer;
    }
    
    private void dfs(String name, int level){
        if(isSolved){
            return;
        }
        if(level==size){
            answer = new String[visitedName.size()];
            for(int i = 0 ; i < visitedName.size() ; i++){
                answer[i] = visitedName.get(i);
                isSolved = true;
            }
            return;
        }
        if(!map.containsKey(name)){
            return;
        }
        for(int i = 0 ; i<map.get(name).size() ; i++){
            Pair pair = map.get(name).get(i);
            if(!visited[pair.getIdx()]){
                visited[pair.getIdx()] = true;
                visitedName.add(pair.getName());
                dfs(pair.getName(),level+1);
                visited[pair.getIdx()] = false;
                visitedName.remove(visitedName.size()-1);
            }
        }
    }
    
}

class Pair{
    private String name;
    private int idx;
    
    public Pair(String name, int idx){
        this.name = name;
        this.idx = idx;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getIdx(){
        return this.idx;
    }
}