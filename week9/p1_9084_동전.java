package week9;

import java.io.*; 
import java.util.*; 

public class p1_9084_동전 {
	static int[] pri;
	static int[][] dp; 
	static int N,M; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int T = Integer.parseInt(br.readLine()); 
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine()); 
			pri = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =1; j <= N; j++) {
				pri[j] = Integer.parseInt(st.nextToken()); 
			}
			M = Integer.parseInt(br.readLine());
			dp = new int[N + 1][M + 1]; 			
			for(int x = 1; x < N+1 ; x++) {
				for(int y = 0; y < M+1; y++) {
					if(y == 0) {dp[x][y] = 1; continue; }
					if( x == 1) {if(y % pri[1]  == 0) {dp[x][y] = 1;} else {dp[x][y] = 0;}  }
					if(y < pri[x]) {dp[x][y] = dp[x-1][y]; continue; }
					dp[x][y] = dp[x-1][y] + dp[x][y - pri[x]]; 
				}
			}
			System.out.println(dp[N][M]);
		}
	}
}
