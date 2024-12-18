import java.util.*;
class Node{
    public int value;
    public int x;
    public int y;
    public Node right;
    public Node left;
    public Node(int value, int x, int y, Node right, Node Left){
        this.value = value;
        this.x = x;
        this.y = y;
        this.right = right;
        this.left = left;
    }
}

class Solution {
    private int idx = 0;
    private int[][] result;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i = 0; i<nodeinfo.length ; i++){
            nodes[i] = new Node(i+1,nodeinfo[i][0],nodeinfo[i][1],null,null);
        }
        
        Arrays.sort(nodes, new Comparator<Node>(){
            public int compare(Node a, Node b){
                if(a.y==b.y){
                    return a.x-b.x; // 오름차순
                }
                return b.y-a.y; // 내림차순
            }
        });
        
        Node parent = nodes[0];
        
        for(int i = 1 ; i<nodeinfo.length; i++){
            makeTree(parent,nodes[i]);      // 트리 구축 
        }
        
        result = new int[2][nodeinfo.length];
        
        preOrder(parent);
        idx = 0;
        postOrder(parent);
        
        return answer=result;
    }
    
    private void makeTree(Node parent, Node child){
        if(parent.x<child.x){
            if(parent.right==null){
                parent.right = child;
            }
            else{
                makeTree(parent.right, child);
            }
        }
        else{
            if(parent.left == null){
                parent.left = child;
            }
            else{
                makeTree(parent.left,child);
            }
        }
    }
    
    private void preOrder(Node parent){
        if(parent!=null){
            result[0][idx++] = parent.value;
            preOrder(parent.left);
            preOrder(parent.right);
        }
    }
    private void postOrder(Node parent){
        if(parent!=null){
            postOrder(parent.left);
            postOrder(parent.right);
            result[1][idx++] = parent.value;
        }
    }
}
