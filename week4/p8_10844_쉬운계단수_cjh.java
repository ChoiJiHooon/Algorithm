package week4;

import java.io.*; 
import java.util.*; 

public class p8_10844_쉬운계단수_cjh {
	static int N; 
	static int[][] dp; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int [N][10];
		Arrays.fill(dp[0], 1);
		easy(0);
	}
	private static void easy(int cnt) {
		int ans = 0; 
		if(cnt == N) {
			for( int i = 1; i < 10; i++) {ans+= dp[N-1][i];}
			System.out.println(ans);
			return; 
		}
		
		if(cnt == 0) {
			easy(cnt+1);return; 
		} else {
			dp[cnt][0] = dp[cnt - 1][1]; 
			dp[cnt][9] = dp[cnt - 1][8];
			for(int i = 1; i <= 8; i++) {
				dp[cnt][i] = dp[cnt - 1][i-1] + dp[cnt - 1][i + 1];
			}
			easy(cnt+1);
			return; 
		}
		
	}

}
