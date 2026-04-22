import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
    static int[] parentNum;
    static List<Integer>[] childNum;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int V = sc.nextInt();
            int E = sc.nextInt();
            int target1 = sc.nextInt();
            int target2 = sc.nextInt();
            parentNum = new int[V+1];
            childNum = new List[V+1];
            for(int v=1; v<=V; v++){
                childNum[v] = new ArrayList<>();
            }
            
            for(int e=0; e<E; e++){
                int p = sc.nextInt();
                int c = sc.nextInt();
                parentNum[c] = p;
                childNum[p].add(c);
            }
            
            List<Integer> route1 = new ArrayList<>();
            int curNum= target1;
            while(curNum != 1){
                route1.add(parentNum[curNum]);
                curNum = parentNum[curNum];
            }
            
            List<Integer> route2 = new ArrayList<>();
            curNum= target2;
            while(curNum != 1){
                route2.add(parentNum[curNum]);
                curNum = parentNum[curNum];
            }
            
            //앞에서부터 비교
            Collections.reverse(route1);
            Collections.reverse(route2);
            int idx = 0;
            int len = Math.min(route1.size(), route2.size());
            while(idx < len){
                if(!route1.get(idx).equals(route2.get(idx))) break;
                idx++;
            }
            
            int subroot = route1.get(idx-1);	//공통조상
                
            //서브트리
            Queue<Integer> q = new ArrayDeque<>();
            q.add(subroot);
            int cnt = 1;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int i=0; i<childNum[cur].size(); i++){
                    q.add(childNum[cur].get(i));
                    cnt++;
                }
            }
            
            System.out.println("#"+test_case+" "+subroot+" "+cnt);
		}
	}
}