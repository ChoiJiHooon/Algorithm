package a0705.knapsack;

import java.io.*; 
import java.util.*; 

public class p6_12865_cjh_평범한배낭 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int W = sc.nextInt();
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		for(int i =0; i < N; i++) {
			weights[i] = sc.nextInt(); 
			profits[i] = sc.nextInt(); 
		}
		int[] dp = new int[W + 1];
		for(int i = 0 ; i <N; i++) {
			//for(int w = 1; w <= W ; w++) {
			for(int w = W; w >=1 ; w--) {
				if(weights[i] <=w) {
					dp[w] = Math.max(dp[w], profits[i]+dp[w-weights[i]]); 
		
				}
			}
		}
		System.out.println(dp[W]);
		sc.close(); 
	}

}
