import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer>[] from = new List[N+1];
        int[] to = new int[N+1];
        boolean[] visited = new boolean[N+1];
        
        for(int n=1; n<=N; n++) {
        	from[n] = new ArrayList<>();
        }
        
        for(int m=0; m<M; m++) {
        	int tall = sc.nextInt();
        	int small = sc.nextInt();	
        	from[tall].add(small);	// 줄 선 뒤 다음 사람 목록
        	to[small]++;	// 줄 서기 전에 앞에 서는 사람 수
        }
        
        Queue<Integer> start = new ArrayDeque<>();
        for(int n=1; n<=N; n++) {	// 맨 앞에 서 있을 수 있는 경우
        	if(to[n] == 0) start.add(n);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!start.isEmpty()) {
        	int curNode = start.poll();
        	sb.append(curNode).append(" ");
        	visited[curNode] = true;
        	
        	for(int nextNode: from[curNode]) {        		
        		to[nextNode]--;
        		if(to[nextNode] == 0) start.add(nextNode);
        	}
        }
        
        for(int n=1; n<=N; n++) {
        	if(!visited[n]) sb.append(n).append(" ");
        }
        System.out.println(sb.toString());
    }
}