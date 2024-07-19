package week3;

import java.io.* ; 
import java.util.*; 

public class p5_1309_동물원_최지훈 {
	static int N; 
	static int[] dp; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		zoo();
	}
	static void zoo() {
		dp[0] = 1; dp[1] = 2; 
		if(N >=3) {	
			for(int i = 2; i < N; i++) {
				dp[i] = (dp[i-1] * 2 + dp[i -2]) % 9901 ; 
			}
		}
		
		System.out.println((dp[N-1]*3 + dp[N-2]) % 9901);
	}

}