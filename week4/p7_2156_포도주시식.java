package week4;

import java.io.*; 
import java.util.*; 

public class p7_2156_포도주시식 {
	static int N; 
	static int[] dp,pro;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine());
		pro = new int[N+1];
		dp = new int[N+1];
		for(int  i = 1; i <= N; i++) {
			pro[i] = Integer.parseInt(br.readLine());
		}
		grapes(1);
		
	}
	private static void grapes(int cnt) {
		dp[0] = 0; 
		if(cnt == N + 1) {System.out.println(dp[N]); return;}
		if(cnt == 1) 		{dp[1] = pro[1];         grapes(cnt+1);return;}
		else if(cnt == 2)	{dp[2] = pro[1] + pro[2];grapes(cnt+1);return;} 
		else if (cnt == 3)  {dp[3] = Math.max(pro[3] + pro[2],pro[3] + pro[1]) ; dp[3] = Math.max(dp[2],dp[3]); grapes(cnt+1);return;}
		else {
			dp[cnt] = Math.max(pro[cnt] + pro[cnt-1] + dp[cnt - 3], pro[cnt] + dp[cnt - 2]);
			dp[cnt] = Math.max(dp[cnt - 1],dp[cnt]);
			grapes(cnt+1);return;
		}
	}

}
