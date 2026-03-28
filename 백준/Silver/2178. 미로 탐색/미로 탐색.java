import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[][] area = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        
        for(int n=0; n<N; n++){
            stk = new StringTokenizer(br.readLine());
            char[] tmp = stk.nextToken().toCharArray();
            for(int m=0; m<M; m++){
                area[n][m] = tmp[m] - '0';
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});
        int answer = 0;
        
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            if(info[0]==N-1 && info[1]==M-1){
                answer = info[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                int nr = info[0] + dr[i];
                int nc = info[1] + dc[i];
                
                if(nr>=0 && nr<N && nc>=0 && nc<M && area[nr][nc]==1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, info[2]+1});
                }
            }
        }
        
        System.out.print(answer);
    }
}