import java.util.*;

class Solution {
    static int[][] l;
    static boolean[][] visited;
    static int n, m, oil[];
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    
    static void bfs(int r, int c){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] oilCol = new boolean[m];
        queue.add(new int[]{r,c});
        visited[r][c] = true;
        
        int oilCnt=0;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            oilCnt++;
            oilCol[pos[1]] = true;
            
            int nr=0, nc=0;
            for(int i=0; i<4; i++){
                nr = pos[0]+dr[i];
                nc = pos[1]+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && l[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        
        for(int i=0; i<m;i++){
            if(oilCol[i]) oil[i] += oilCnt;
        }
    }
    
    public int solution(int[][] land) {
        l=land;
        n = land.length;    //row
        m = land[0].length; //col
        visited = new boolean[n][m];
        oil = new int[m];
        
        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                if(l[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        
        int answer= Arrays.stream(oil).max().getAsInt();
        return answer;
    }
}