import java.util.*;
import java.io.*;

class Main{
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] area = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
        	char[] c = sc.next().toCharArray();
        	for(int j=0; j<N; j++) {
        		area[i][j] = c[j];
        	}
        }
        
        PriorityQueue<Integer> house = new PriorityQueue<>();
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(area[i][j] == '1' && !visited[i][j]) {
        			Queue<int[]> queue = new ArrayDeque<>();
        			queue.add(new int[] {i,j});
        			visited[i][j] = true;
        			
        			int cnt=0;
        			while(!queue.isEmpty()) {
        				int[] cur = queue.poll();
        				cnt++;
        				
        				for(int k=0; k<4; k++) {
        					if(cur[0]+dx[k]>=0 && cur[0]+dx[k]<N && cur[1]+dy[k]>=0 && cur[1]+dy[k]<N) {
        						if(area[cur[0]+dx[k]][cur[1]+dy[k]] == '1' && !visited[cur[0]+dx[k]][cur[1]+dy[k]]) {
        							visited[cur[0]+dx[k]][cur[1]+dy[k]] = true;
        							queue.add(new int[] {cur[0]+dx[k], cur[1]+dy[k]});
        						}
        					}
        				}
        			}
        			
        			house.add(cnt);
        		}
        	}
        }
        
        System.out.println(house.size());
        while(!house.isEmpty()) {
        	System.out.println(house.poll());
        }
    }
}