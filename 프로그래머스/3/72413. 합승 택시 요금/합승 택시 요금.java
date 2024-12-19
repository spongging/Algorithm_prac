import java.util.*;

class Node{
    int vertex;
    int cost;
    
    public Node(int v,int c){
        this.vertex = v;
        this.cost = c;
    }
}

class Solution {
    
    private List<Node>[] graph;
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];
        for(int i = 0 ; i<n+1 ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i<fares.length ; i++){
            graph[fares[i][0]].add(new Node(fares[i][1],fares[i][2]));
            graph[fares[i][1]].add(new Node(fares[i][0],fares[i][2]));
        }
        
        int[] startS = dijkstra(n,s);
        int[] startA = dijkstra(n,a);
        int[] startB = dijkstra(n,b);
        
        for(int i = 1 ; i<=n ; i++){
           if (startS[i] != Integer.MAX_VALUE && startA[i] != Integer.MAX_VALUE && startB[i] != Integer.MAX_VALUE) {
            answer = Math.min(answer, startS[i] + startA[i] + startB[i]);
             }
        }
        return answer;
     }
    
    private int[] dijkstra(int n, int start){
        boolean visited[] = new boolean[n+1];
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        pq.offer(new Node(start,0));
        
        while(!pq.isEmpty()){
            
            int curVertex = pq.poll().vertex;
            if(visited[curVertex]) continue;
            visited[curVertex] = true;
            
            for(int i = 0 ; i < graph[curVertex].size() ; i++){
                
                int nextVertex = graph[curVertex].get(i).vertex;
                int nextCost = graph[curVertex].get(i).cost;
                
                if(dist[nextVertex]>dist[curVertex] + nextCost){
                    dist[nextVertex] = dist[curVertex] + nextCost;
                    pq.offer(new Node(nextVertex,dist[nextVertex]));
                }
            }
        }
        
        return dist;
    }
}

