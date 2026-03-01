import java.io.*;
import java.util.*;

class Main{
    static List<Integer>[] edges;
    static boolean[] visited;
    
    static void dfs(int curNode){
        System.out.print(curNode+" ");
        for(int next: edges[curNode]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
    
    static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int curNode = queue.poll();
            System.out.print(curNode+" ");
            
            for(int next: edges[curNode]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        
        edges = new List[N+1];        
        for(int n=1; n<=N; n++){
            edges[n] = new ArrayList<>();
        }
        
        for(int m=0; m<M; m++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            
            edges[node1].add(node2);
            edges[node2].add(node1);
        }
        
        for(int n=1; n<=N; n++){
            Collections.sort(edges[n]);
        }
        
        visited = new boolean[N+1];
        visited[V] = true;
        dfs(V);
        
        System.out.println();
        
        visited = new boolean[N+1];
        bfs(V);
    }
}