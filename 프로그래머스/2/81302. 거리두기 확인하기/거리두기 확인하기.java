import java.util.*;

class Solution {
    private char[][] arr = new char[5][5];
    private int[] da = {0,0,1,-1};
    private int[] db = {1,-1,0,0};
    private boolean[][] visited;
    private int[] answer = new int[5];
    
    public int[] solution(String[][] places) {
        for(int i = 0 ; i < places.length ; i++){
            init(places[i]);
            
            if(isFollowing()){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private void init(String[] places){
        visited = new boolean[5][5];
        
        for(int i = 0 ; i < places.length ; i++){
            String s = places[i];
            for(int j = 0 ; j < s.length() ; j++){
                arr[i][j] = s.charAt(j);
            }   
        }
    }
    
    private boolean isFollowing(){
        ArrayList<Pair> xArr;
        
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                if(arr[i][j] == 'P' && !visited[i][j]){
                    xArr = new ArrayList<>();
                    bfs(i, j, xArr);
                    
                    if(!cal(xArr)){
                        return false;
                    }
                }  
            }
        }
        
        return true;
        
    }
    
    private boolean cal(ArrayList<Pair> xArr){
        for(int i = 0 ; i < xArr.size() ; i++){
            Pair p1 = xArr.get(i);
            for(int j = i + 1 ; j < xArr.size() ; j++){
                Pair p2 = xArr.get(j);
                if(Math.abs(p1.getA() - p2.getA()) + Math.abs(p1.getB() - p2.getB()) <= 2){
                    return false;
                }
            }
        }
        return true;
    }
    
    private void bfs(int a, int b, ArrayList<Pair> xArr){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a,b,0));
        xArr.add(new Pair(a,b));
        visited[a][b] = true;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();
            int depth = p.getDepth();
            
            if(depth >= 2) continue;
            
            for(int i = 0 ; i < 4 ; i++){
                int na = aa + da[i];
                int nb = bb + db[i];
                if(na>=0 && na<=4 && nb>=0 && nb<=4 && !visited[na][nb] && arr[na][nb] != 'X'){
                    Pair np = new Pair(na, nb, depth + 1);
                    if(arr[na][nb]=='P'){
                       xArr.add(np);
                    }
                    visited[na][nb] = true;
                    q.add(np);
                }
            }
        }
    }
}

class Pair{
    int a;
    int b;
    int depth;
    
    public Pair(int a, int b){
        this.a = a;
        this.b = b;
        this.depth = 0;
    }
    
    public Pair(int a, int b, int depth){
        this.a = a;
        this.b = b;
        this.depth = depth;
    }
    
    public int getA(){
        return this.a;
    }
    
    public int getB(){
        return this.b;
    }
    
    public int getDepth(){
        return this.depth;
    }
}
