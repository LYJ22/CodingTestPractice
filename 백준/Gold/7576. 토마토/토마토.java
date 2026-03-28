import java.io.*;
import java.util.*;

class Main{
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int area[][] = new int[N][M];
        
        Queue<int[]> queue = new ArrayDeque<>();
        int rawTomatoes=0;
        
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                area[n][m]=sc.nextInt();
                //익은 토마토 큐에 저장
                if(area[n][m]==1) queue.add(new int[]{n,m,0});
                //안 익은 토마토 개수
                if(area[n][m]==0) rawTomatoes++;
            }
        }
        
        int answer=0;
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            answer = info[2];
            
            for(int i=0; i<4; i++){
                int nr = info[0] + dr[i];
                int nc = info[1] + dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && area[nr][nc] == 0){
                    area[nr][nc] = 1;
                    rawTomatoes--;
                    queue.add(new int[]{nr, nc, info[2]+1});
                }
            }
        }
        
        System.out.print(rawTomatoes == 0 ? answer : -1);
    }
}