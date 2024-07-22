package week5;

import java.io.*; 
import java.util.*; 

public class p0_11057_오르막수_cjh {
	static int N;
	static long[][] dp; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long [N][10];
		for(int i = 0; i < N; i++)Arrays.fill(dp[i], 0);
		Arrays.fill(dp[0], 1);
		uphill(1);
	}
	static void uphill(int cnt) {
		long ans = 0; 
		if(cnt == N) {
			for(int i = 0; i < 10; i++) {
				ans = (ans +  dp[N-1][i]) % 10007;
			}
			System.out.println(ans);return; 
		}
		else {
			for(int i = 0; i < 10; i++) {
				for(int j = i ; j < 10; j++) {
					dp[cnt][i] = (dp[cnt][i] +  dp[cnt-1][j]) % 10007;
				}
			}
			uphill(cnt+1); return; 
		}
	}

}
