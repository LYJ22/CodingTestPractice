class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        //초기 숙련도 =  최고 난이도 레벨
        int minlvl=1, maxlvl=0;
        for(int d=0; d < diffs.length; d++){
            if(maxlvl < diffs[d]) maxlvl = diffs[d];
        }
        
        //초기 숙련도부터 이진 분할
        answer = -1;
        while(maxlvl >= minlvl){
            //lvl일 때 소요 시간
            int curlvl = (maxlvl+minlvl)/2;
            long time=0;
            for(int d=0; d < diffs.length; d++){
                if(diffs[d] <= curlvl) time += times[d];
                else{
                    int repeat = diffs[d] - curlvl;
                    time += (times[d] + times[d-1])*repeat + times[d];
                }
            }
            //limit 만족하는지 체크
            if(time <= limit){
                answer = curlvl;
                maxlvl = curlvl-1;
            }
            else minlvl = curlvl+1;
        }
        
        return answer;
    }
}