package week9;
	
	import java.io.*;
	import java.util.*; 
	
	public class p4_4781_사탕가계 {
		static int n; 
		static double m; 
		static int[] dp;  
		 public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Queue<Integer> ans  = new LinkedList<>(); 
			while(true) {
			StringTokenizer st =new StringTokenizer(br.readLine()); 
			n = Integer.parseInt(st.nextToken());    //캔디개수
			m =  Double.parseDouble(st.nextToken()); //가격 
			if(n == 0 && m == 0.00) {break;}
			int M = (int)(m*100 + 0.5); 
			dp = new int[M + 1];
			
			for(int i = 1; i <= n; i++) {
				StringTokenizer st1 =new StringTokenizer(br.readLine()); 
				int cal = Integer.parseInt(st1.nextToken());                //칼로리
				int pri =  (int)(Double.parseDouble(st1.nextToken()) * 100 + 0.5);//가격
				 if(pri > M) continue;
				 for (int j = pri; j < M + 1; ++j) {
	                    dp[j] = Math.max(dp[j], dp[j - pri] + cal);
	                }
			}
			ans.offer(dp[M]); 
			}
			while(!ans.isEmpty()) {
				System.out.println(ans.poll());
			}
		 }
	}
