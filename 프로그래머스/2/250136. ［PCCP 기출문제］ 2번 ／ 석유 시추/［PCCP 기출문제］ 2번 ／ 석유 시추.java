import java.util.*;

class Solution {
    private int[] da = {0,0,1,-1};
    private int[] db = {1,-1,0,0};
    private static int answer = 0; 
    private boolean[][] visited;
    private static int columnSize;
    private static int rowSize;
    private int[] areaSize;
    
    public int solution(int[][] land) {
        int cnt = 0;
        rowSize = land.length;
        columnSize = land[0].length;
        visited = new boolean[rowSize][columnSize];
        areaSize = new int[columnSize];
        
        for(int i = 0 ; i < rowSize ; i++){
            for(int j = 0 ; j < columnSize ; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    bfs(i,j,land,areaSize);                   
                }
            }
        }
        
        for(int num : areaSize){
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
    
    private void bfs(int a, int b, int[][] land, int[] areaSize){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b));
        visited[a][b] = true;
        HashSet<Integer> columns = new HashSet<>();
        int cnt = 1;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();
            
            columns.add(bb);
            
            for(int i = 0 ; i < 4 ; i++){
                int na = aa + da[i];
                int nb = bb + db[i];
                
                if(na>=0 && na < rowSize && nb>=0 && nb<columnSize && land[na][nb]==1 && !visited[na][nb]){
                    visited[na][nb] = true;
                    cnt++;
                    q.add(new Pair(na, nb));
                }
            }
        }
        
        for(int c : columns){
            areaSize[c] +=  cnt;
        }
        
        return;
    }
}

class Pair{
    int a;
    int b;
    
    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
    
    public int getA(){
        return this.a;
    }
    
    public int getB(){
        return this.b;
    }
    
}