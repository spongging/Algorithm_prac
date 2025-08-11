import java.util.*;

class Solution {
    private int answer;
    
    private int[][] rectangle;
    private final int[] da = {0,0,1,-1};
    private final int[] db = {1,-1,0,0};
    private final int[][] map = new int[101][101];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.rectangle = rectangle;
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        getBorder();
        
        return getAnswer(characterY, characterX, itemY, itemX) / 2;
    }
    
    private int getAnswer(int initA, int initB, int targetA, int targetB){
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        
        q.add(new Pair(initA, initB, 0));
        visited[initA][initB] = true;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int aa = p.getA();
            int bb = p.getB();
            int cnt = p.getCnt();
            
            if (aa == targetA && bb == targetB) return cnt;
            
            for (int i = 0 ; i < 4 ; i++){
                int na = aa + da[i];
                int nb = bb + db[i];
                
                if(na >= 0 && nb >= 0 && na < 101 && nb < 101 && map[na][nb]==1){
                    if(!visited[na][nb]){
                        visited[na][nb] = true;
                        q.add(new Pair(na, nb, cnt+1));
                    }
                }
            }
        }
        
        return -1;
    }
    
    private void getBorder(){
        for (int[] r : rectangle){
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for (int a = y1 ; a <= y2 ; a++){
                for (int b = x1 ; b <= x2 ; b++){
                    if(map[a][b]==-1) continue;
                    
                    if (a==y1 || a==y2 || b==x1 || b==x2){
                        map[a][b] = 1;
                    }else map[a][b] = -1;
                }
            }
        }
    }
}

class Pair{
    private final int a;
    private final int b;
    private final int cnt;
    
    public Pair(int a, int b , int cnt){
        this.a = a;
        this.b = b;
        this.cnt = cnt;
    }
    
    public int getA(){
        return this.a;
    }
    
    public int getB(){
        return this.b;
    }
    
    public int getCnt(){
        return this.cnt;
    }
}