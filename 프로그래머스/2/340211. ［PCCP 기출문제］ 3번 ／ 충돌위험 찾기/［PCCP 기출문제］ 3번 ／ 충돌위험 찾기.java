import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int robotCnt = routes.length;   //남은 로봇
        boolean[] isFinished = new boolean[robotCnt];
        int[][] area = new int[101][101];
        int[][] robotPos = new int[robotCnt][2];    //로봇 위치
        int[] nextPointIdx = new int[robotCnt];    //routes index
        
        //초기 설정
        for(int i = 0; i<robotCnt; i++){
            int startPoint = routes[i][0];
            int r = points[startPoint-1][0];
            int c = points[startPoint-1][1];
            
            //로봇 초기 위치
            robotPos[i][0] = r;
            robotPos[i][1] = c;
            //구역 당 로봇 존재 여부
            area[r][c] += 1;
            if(area[r][c]==2) answer++; //초기 단계에서 위험상황 발생
            //목적지 포인트
            nextPointIdx[i] = 1;
        }
        
        while(robotCnt > 0){
            //area 초기화
            for(int r = 1; r<= 100; r++){
                Arrays.fill(area[r], 0);
            }
            
            //로봇 이동
            for(int i = 0; i<routes.length; i++){
                if(isFinished[i]) continue;
                int curR = robotPos[i][0];
                int curC = robotPos[i][1];
                int targetPointNum = routes[i][nextPointIdx[i]];
                if(points[targetPointNum-1][0] > robotPos[i][0]){
                    curR += 1;
                }else if(points[targetPointNum-1][0] < robotPos[i][0]){
                    curR -= 1;
                }else if(points[targetPointNum-1][1] > robotPos[i][1]){
                    curC += 1;
                }else if(points[targetPointNum-1][1] < robotPos[i][1]){
                    curC -= 1;
                }
                area[curR][curC] += 1;
                if(area[curR][curC] == 2) answer++;
        
                robotPos[i][0] = curR;
                robotPos[i][1] = curC;
                
                //로봇이 목적지에 도착한 경우
                if(robotPos[i][0] == points[targetPointNum-1][0]
                   && robotPos[i][1] == points[targetPointNum-1][1]){
                    //다음 목적지 존재
                    if(nextPointIdx[i] < routes[i].length-1) nextPointIdx[i]++;
                    //경로 이동 끝
                    else{
                        isFinished[i] = true;
                        robotCnt--;
                    }
                }
            }
        }
        
        return answer;
    }
}